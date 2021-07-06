package com.shiftkey.codingchallenge.data.repository

import com.shiftkey.codingchallenge.data.api.service.ShiftService
import com.shiftkey.codingchallenge.data.cache.DataCache
import com.shiftkey.codingchallenge.data.di.ShiftItemListMapperQualifier
import com.shiftkey.codingchallenge.data.di.ShiftsDetailsMapperQualifier
import com.shiftkey.codingchallenge.data.di.WelcomeCacheQualifier
import com.shiftkey.codingchallenge.data.mapper.Mapper
import com.shiftkey.codingchallenge.data.model.Shift
import com.shiftkey.codingchallenge.data.model.Welcome
import com.shiftkey.codingchallenge.domain.model.ShiftDetailsItem
import com.shiftkey.codingchallenge.domain.model.ShiftItem
import com.shiftkey.codingchallenge.domain.repository.ShiftsRepository
import io.reactivex.Flowable
import javax.inject.Inject

class ShiftsRepositoryImpl @Inject constructor(
    private val shiftService: ShiftService,
    @ShiftItemListMapperQualifier private val welcomeToShiftItemsMapper: Mapper<Welcome, List<ShiftItem>>,
    @ShiftsDetailsMapperQualifier private val shiftToShiftDetailsMapper: Mapper<Shift, ShiftDetailsItem>,
    @WelcomeCacheQualifier private val cache: DataCache<Welcome>,
) : ShiftsRepository {

    override fun fetchAvailableShifts(start: String, address: String): Flowable<List<ShiftItem>> =
        Flowable.merge(
            cache.getData(Welcome::class.java.simpleName)
                ?.let { data -> Flowable.just(data) } ?: Flowable.empty(),
            shiftService.getAvailableShifts(
                start = start,
                address = address,
            ).toFlowable()
        )
            .map { response -> cache.putData(Welcome::class.java.simpleName, response) }
            .map(welcomeToShiftItemsMapper::map)

    override fun fetchShiftDetails(shiftId: Long): Flowable<ShiftDetailsItem> =
        cache.getData(Welcome::class.java.simpleName)?.let { data ->
            Flowable.just(data)
                .map { welcome ->
                    welcome.data.forEach { datum ->
                        datum.shifts.forEach { shift ->
                            if (shift.shift_id == shiftId) return@map shift
                        }
                    }
                    throw IllegalArgumentException("ShiftDetailsItem for $shiftId id not found")
                }
        }?.map(shiftToShiftDetailsMapper::map)
            ?: Flowable.empty()
}
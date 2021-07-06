package com.shiftkey.codingchallenge.data.repository

import com.shiftkey.codingchallenge.data.api.service.ShiftService
import com.shiftkey.codingchallenge.data.cache.DataCache
import com.shiftkey.codingchallenge.data.mapper.Mapper
import com.shiftkey.codingchallenge.data.model.Meta
import com.shiftkey.codingchallenge.data.model.Shift
import com.shiftkey.codingchallenge.data.model.Welcome
import com.shiftkey.codingchallenge.domain.model.ShiftDetailsItem
import com.shiftkey.codingchallenge.domain.model.ShiftItem
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ShiftsRepositoryImplTest {

    @Mock
    lateinit var shiftService: ShiftService ///= Mockito.mock(ShiftService::class.java)

    @Mock
    lateinit var welcomeToShiftItemsMapper: Mapper<Welcome, List<ShiftItem>>

    @Mock
    lateinit var shiftToShiftDetailsMapper: Mapper<Shift, ShiftDetailsItem>

    @Mock
    lateinit var cache: DataCache<Welcome>

    @InjectMocks
    lateinit var repository: ShiftsRepositoryImpl

    @Test
    fun fetchAvailableShifts() {
        //given
        val welcomeResponse = Welcome(
            data = emptyList(),
            links = emptyList(),
            meta = Meta(),
        )
        val shiftItems = listOf(
            ShiftItem(
                shiftId = 80,
                date = "date",
                shiftKind = "shiftKind",
                facilityTypeName = "facilityTypeName",
                skillName = "skillName",
                localizedName = "localizedName",
            )
        )
        Mockito.`when`(cache.getData(Welcome::class.java.simpleName)).thenReturn(null)
        Mockito.`when`(cache.putData(Welcome::class.java.simpleName, welcomeResponse)).thenReturn(welcomeResponse)
        Mockito.`when`(
            shiftService.getAvailableShifts(
                start = "start",
                address = "address",
            )
        ).thenReturn(Single.just(welcomeResponse))
        Mockito.`when`(welcomeToShiftItemsMapper.map(welcomeResponse)).thenReturn(shiftItems)
        //when
        val result = repository.fetchAvailableShifts("start", "address").blockingFirst()
        //then
        verify(cache).putData(Welcome::class.java.simpleName, welcomeResponse)
        verify(welcomeToShiftItemsMapper).map(welcomeResponse)
        assert(result == shiftItems)
    }
}
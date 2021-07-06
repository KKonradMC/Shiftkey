package com.shiftkey.codingchallenge.domain.usecase

import com.shiftkey.codingchallenge.domain.model.ShiftDetailsItem
import com.shiftkey.codingchallenge.domain.repository.ShiftsRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetShiftDetailsUseCaseImpl @Inject constructor(
    private val shiftsRepository: ShiftsRepository,
) : GetShiftDetailsUseCase {

    override fun invoke(id: Long): Flowable<ShiftDetailsItem> =
        shiftsRepository.fetchShiftDetails(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

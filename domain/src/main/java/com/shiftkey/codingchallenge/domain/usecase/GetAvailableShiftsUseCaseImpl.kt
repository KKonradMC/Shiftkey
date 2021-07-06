package com.shiftkey.codingchallenge.domain.usecase

import android.annotation.SuppressLint
import com.shiftkey.codingchallenge.domain.model.ShiftItem
import com.shiftkey.codingchallenge.domain.repository.ShiftsRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class GetAvailableShiftsUseCaseImpl @Inject constructor(
    private val shiftsRepository: ShiftsRepository,
) : GetAvailableShiftsUseCase {

    @SuppressLint("SimpleDateFormat")
    override fun invoke(date: Date): Flowable<List<ShiftItem>> =
        shiftsRepository.fetchAvailableShifts(
            start = SimpleDateFormat(" YYYY-MM-DD").format(date),
            address = DALLAS_TX,
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}

private const val DALLAS_TX = "Dallas, TX"

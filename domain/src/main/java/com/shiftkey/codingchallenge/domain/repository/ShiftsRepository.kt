package com.shiftkey.codingchallenge.domain.repository

import com.shiftkey.codingchallenge.domain.model.ShiftDetailsItem
import com.shiftkey.codingchallenge.domain.model.ShiftItem
import io.reactivex.Flowable

interface ShiftsRepository {

    fun fetchAvailableShifts(start: String, address: String): Flowable<List<ShiftItem>>

    fun fetchShiftDetails(shiftId: Long): Flowable<ShiftDetailsItem>
}

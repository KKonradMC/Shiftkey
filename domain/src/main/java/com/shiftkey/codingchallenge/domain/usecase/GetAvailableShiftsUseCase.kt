package com.shiftkey.codingchallenge.domain.usecase

import com.shiftkey.codingchallenge.domain.model.ShiftItem
import io.reactivex.Flowable
import java.util.*

interface GetAvailableShiftsUseCase : Function1<Date, Flowable<List<ShiftItem>>>

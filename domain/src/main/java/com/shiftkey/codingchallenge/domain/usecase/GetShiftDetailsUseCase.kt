package com.shiftkey.codingchallenge.domain.usecase

import com.shiftkey.codingchallenge.domain.model.ShiftDetailsItem
import io.reactivex.Flowable

interface GetShiftDetailsUseCase : Function1<Long, Flowable<ShiftDetailsItem>>

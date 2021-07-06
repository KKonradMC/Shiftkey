package com.shiftkey.codingchallenge.data.api.service

import com.shiftkey.codingchallenge.data.model.Welcome
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject

class ShiftServiceImpl @Inject constructor(
    private val retrofit: Retrofit,
) : ShiftService {

    override fun getAvailableShifts(
        start: String?,
        type: Int?,
        address: String?,
        radius: Int?
    ): Single<Welcome> =
        retrofit.create(ShiftService::class.java).getAvailableShifts(start, type, address, radius)
}

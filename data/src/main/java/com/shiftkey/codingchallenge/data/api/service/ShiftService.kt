package com.shiftkey.codingchallenge.data.api.service

import com.shiftkey.codingchallenge.data.api.Endpoint
import com.shiftkey.codingchallenge.data.api.QueryParam
import com.shiftkey.codingchallenge.data.model.Welcome
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ShiftService {

    @GET(Endpoint.AVAILABLE_SHIFTS)
    fun getAvailableShifts(
        @Query(QueryParam.START) start: String? = null,
        @Query(QueryParam.TYPE) type: Int? = null,
        @Query(QueryParam.ADDRESS) address: String? = null,
        @Query(QueryParam.RADIUS) radius: Int? = null,
    ): Single<Welcome>
}

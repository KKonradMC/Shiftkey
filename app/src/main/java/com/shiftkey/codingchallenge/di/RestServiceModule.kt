package com.shiftkey.codingchallenge.di

import com.shiftkey.codingchallenge.data.api.service.ShiftService
import com.shiftkey.codingchallenge.data.api.service.ShiftServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RestServiceModule {

    @Binds
    abstract fun bind(shiftServiceImpl: ShiftServiceImpl): ShiftService
}
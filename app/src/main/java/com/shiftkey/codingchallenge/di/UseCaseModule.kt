package com.shiftkey.codingchallenge.di

import com.shiftkey.codingchallenge.domain.usecase.GetAvailableShiftsUseCase
import com.shiftkey.codingchallenge.domain.usecase.GetAvailableShiftsUseCaseImpl
import com.shiftkey.codingchallenge.domain.usecase.GetShiftDetailsUseCase
import com.shiftkey.codingchallenge.domain.usecase.GetShiftDetailsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetAvailableShiftsUseCaseImpl(getAvailableShiftsUseCase: GetAvailableShiftsUseCaseImpl): GetAvailableShiftsUseCase

    @Binds
    abstract fun bindGetShiftDetailsUseCase(GetShiftDetailsUseCase: GetShiftDetailsUseCaseImpl): GetShiftDetailsUseCase
}

package com.shiftkey.codingchallenge.di

import com.shiftkey.codingchallenge.data.repository.ShiftsRepositoryImpl
import com.shiftkey.codingchallenge.domain.repository.ShiftsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bind(availableShiftsRepository: ShiftsRepositoryImpl): ShiftsRepository
}
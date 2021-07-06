package com.shiftkey.codingchallenge.di

import com.shiftkey.codingchallenge.data.di.ShiftItemListMapperQualifier
import com.shiftkey.codingchallenge.data.di.ShiftsDetailsMapperQualifier
import com.shiftkey.codingchallenge.data.mapper.AvailableShiftsMapper
import com.shiftkey.codingchallenge.data.mapper.Mapper
import com.shiftkey.codingchallenge.data.mapper.ShiftDetailsMapper
import com.shiftkey.codingchallenge.data.model.Shift
import com.shiftkey.codingchallenge.data.model.Welcome
import com.shiftkey.codingchallenge.domain.model.ShiftDetailsItem
import com.shiftkey.codingchallenge.domain.model.ShiftItem
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @ShiftItemListMapperQualifier
    @Provides
    fun provideAvailableShiftsMapper(availableShiftsMapper: AvailableShiftsMapper): Mapper<Welcome, List<ShiftItem>> {
        return availableShiftsMapper
    }

    @ShiftsDetailsMapperQualifier
    @Provides
    fun provideShiftDetailsMapper(shiftDetailsMapper: ShiftDetailsMapper): Mapper<Shift, ShiftDetailsItem> {
        return shiftDetailsMapper
    }
}
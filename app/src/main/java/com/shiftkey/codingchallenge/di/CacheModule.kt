package com.shiftkey.codingchallenge.di

import com.shiftkey.codingchallenge.data.cache.DataCache
import com.shiftkey.codingchallenge.data.cache.WelcomeCache
import com.shiftkey.codingchallenge.data.di.WelcomeCacheQualifier
import com.shiftkey.codingchallenge.data.model.Welcome
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CacheModule {

    @WelcomeCacheQualifier
    @Binds
    abstract fun provides(welcomeCache: WelcomeCache): DataCache<Welcome>
}
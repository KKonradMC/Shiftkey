package com.shiftkey.codingchallenge.data.cache

import com.shiftkey.codingchallenge.data.model.Welcome
import javax.inject.Inject

class WelcomeCache @Inject constructor() : InMemoryDataCache<Welcome>()

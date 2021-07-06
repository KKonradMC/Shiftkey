package com.shiftkey.codingchallenge.data.cache


abstract class InMemoryDataCache<DATA> : DataCache<DATA> {
    private val cache = HashMap<String, DATA>()

    override fun putData(key: String, data: DATA): DATA =
        synchronized(cache) { cache[key] = data; data }

    override fun getData(key: String) =
        synchronized(cache) { cache[key] }
}
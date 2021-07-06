package com.shiftkey.codingchallenge.data.cache

interface DataCache<DATA> {

    fun putData(key: String, data: DATA): DATA

    fun getData(key: String): DATA?
}
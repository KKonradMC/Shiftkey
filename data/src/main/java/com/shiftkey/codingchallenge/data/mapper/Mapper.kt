package com.shiftkey.codingchallenge.data.mapper

interface Mapper<From, To> {
    fun map(from: From): To
}
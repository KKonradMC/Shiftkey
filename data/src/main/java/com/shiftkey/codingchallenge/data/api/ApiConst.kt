package com.shiftkey.codingchallenge.data.api

const val ROOT = "https://staging-app.shiftkey.com"

object Endpoint {
    const val AVAILABLE_SHIFTS = "/api/v2/available_shifts"
}

object QueryParam {
    const val START = "start"
    const val TYPE = "type"
    const val ADDRESS = "address"
    const val RADIUS = "radius"
}

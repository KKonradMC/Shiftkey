package com.shiftkey.codingchallenge.domain.model

data class ShiftDetailsItem(
    val shiftId: Long,
    val startTime: String,
    val endTime: String,
    val premiumRate: Boolean,
    val covid: Boolean,
    val shiftKind: String,
    val facilityTypeName: String,
    val facilityTypeColor: Int,
    val skillName: String,
    val skillColor: Int,
    val localizedName: String,
    val localizedColor: Int,
)

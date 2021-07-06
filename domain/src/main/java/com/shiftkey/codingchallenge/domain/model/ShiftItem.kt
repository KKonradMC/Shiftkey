package com.shiftkey.codingchallenge.domain.model


data class ShiftItem(
    val shiftId: Long,
    val date: String,
    val shiftKind: String,
    val facilityTypeName: String,
    val skillName: String,
    val localizedName: String,
)

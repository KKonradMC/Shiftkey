package com.shiftkey.codingchallenge.data.model

//Genreted by https://quicktype.io

data class Welcome(
    val data: List<Datum>,
    val links: List<Any?>,
    val meta: Meta
)

data class Datum(
    val date: String,
    val shifts: List<Shift>
)

data class Shift(
    val shift_id: Long,
    val start_time: String,
    val end_time: String,
    val normalized_start_date_time: String,
    val normalized_end_date_time: String,
    val timezone: Timezone,
    val premium_rate: Boolean,
    val covid: Boolean,
    val shift_kind: String,
    val within_distance: Any? = null,
    val facility_type: FacilityType,
    val skill: FacilityType,
    val localized_specialty: LocalizedSpecialty
)

data class FacilityType(
    val id: Long,
    val name: String,
    val color: String,
    val abbreviation: String? = null
)


data class LocalizedSpecialty(
    val id: Long,
    val specialty_id: Long,
    val state_id: Long,
    val name: String,
    val abbreviation: String,
    val specialty: FacilityType
)


enum class Timezone {
    Central,
    Eastern,
    Mountain,
    Pacific
}

data class Meta(
    val lat: Any? = null,
    val lng: Any? = null
)

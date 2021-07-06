package com.shiftkey.codingchallenge.data.mapper

import com.shiftkey.codingchallenge.data.model.*
import org.junit.Test

class AvailableShiftsMapperTest {

    private val availableShiftsMapper = AvailableShiftsMapper()

    @Test
    fun map() {
        //given
        val welcome = Welcome(
            data = listOf(
                Datum(
                    date = "date",
                    shifts = listOf(
                        Shift(
                            shift_id = 80L,
                            start_time = "start_time",
                            end_time = "end_time",
                            normalized_start_date_time = "normalized_start_date_time",
                            normalized_end_date_time = "normalized_end_date_time",
                            timezone = Timezone.Central,
                            premium_rate = true,
                            covid = true,
                            shift_kind = "shift_kind",
                            within_distance = null,
                            facility_type = FacilityType(
                                id = 70,
                                name = "facility_type_name",
                                color = "#AABBCC",
                            ),
                            skill = FacilityType(
                                id = 70,
                                name = "skill_name",
                                color = "#AABB00",
                            ),
                            localized_specialty = LocalizedSpecialty(
                                id = 100,
                                specialty_id = 101,
                                state_id = 102,
                                name = "localized_name",
                                abbreviation = "abbreviation",
                                specialty = FacilityType(
                                    id = 70,
                                    name = "localized_name",
                                    color = "#AABB90",
                                )
                            )
                        )
                    )
                )
            ),
            links = emptyList(),
            meta = Meta()
        )
        //when
        val result = availableShiftsMapper.map(welcome)
        //then
        assert(result.size == 1)
        assert(result[0].date == "date")
        assert(result[0].shiftKind == "shift_kind")
        assert(result[0].facilityTypeName == "facility_type_name")
        assert(result[0].skillName == "skill_name")
        assert(result[0].localizedName == "localized_name")
    }

}
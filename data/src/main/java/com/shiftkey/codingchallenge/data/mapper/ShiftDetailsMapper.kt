package com.shiftkey.codingchallenge.data.mapper

import android.graphics.Color
import com.shiftkey.codingchallenge.data.model.Shift
import com.shiftkey.codingchallenge.domain.model.ShiftDetailsItem
import javax.inject.Inject

class ShiftDetailsMapper @Inject constructor() : Mapper<Shift, ShiftDetailsItem> {
    override fun map(from: Shift): ShiftDetailsItem = from.run {
        ShiftDetailsItem(
            shiftId = shift_id,
            startTime = start_time,
            endTime = end_time,
            premiumRate = premium_rate,
            covid = covid,
            shiftKind = shift_kind,
            facilityTypeName = facility_type.name,
            facilityTypeColor = Color.parseColor(facility_type.color),
            skillName = skill.name,
            skillColor = Color.parseColor(skill.color),
            localizedName = localized_specialty.name,
            localizedColor = Color.parseColor(localized_specialty.specialty.color),
        )
    }
}



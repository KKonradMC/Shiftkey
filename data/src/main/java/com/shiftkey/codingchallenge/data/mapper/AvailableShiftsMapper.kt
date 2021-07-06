package com.shiftkey.codingchallenge.data.mapper

import com.shiftkey.codingchallenge.data.model.Welcome
import com.shiftkey.codingchallenge.domain.model.ShiftItem
import java.util.*
import javax.inject.Inject

class AvailableShiftsMapper @Inject constructor() : Mapper<Welcome, List<ShiftItem>> {
    override fun map(from: Welcome): List<ShiftItem> = LinkedList<ShiftItem>().apply {
        from.data.forEach { datum ->
            datum.shifts.forEach { shift ->
                add(
                    ShiftItem(
                        shiftId = shift.shift_id,
                        date = datum.date,
                        shiftKind = shift.shift_kind,
                        facilityTypeName = shift.facility_type.name,
                        skillName = shift.skill.name,
                        localizedName = shift.localized_specialty.name,
                    )
                )
            }
        }
    }
}
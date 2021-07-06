package com.shiftkey.codingchallenge.presentation.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.shiftkey.codingchallenge.domain.model.ShiftItem
import javax.inject.Inject

class ShiftDiffCallback @Inject constructor() : DiffUtil.ItemCallback<ShiftItem>() {

    override fun areItemsTheSame(oldItem: ShiftItem, newItem: ShiftItem): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: ShiftItem, newItem: ShiftItem): Boolean {
        return false
    }
}
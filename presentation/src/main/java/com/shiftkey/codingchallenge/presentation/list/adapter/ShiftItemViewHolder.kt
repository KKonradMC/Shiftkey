package com.shiftkey.codingchallenge.presentation.list.adapter

import androidx.recyclerview.widget.RecyclerView
import com.shiftkey.codingchallenge.domain.model.ShiftItem
import com.shiftkey.codingchallenge.presentation.BR
import com.shiftkey.codingchallenge.presentation.databinding.ViewShiftItemBinding

class ShiftItemViewHolder(
    private val viewDataBinding: ViewShiftItemBinding,
) : RecyclerView.ViewHolder(viewDataBinding.root) {

    fun bind(item: ShiftItem) {
        viewDataBinding.setVariable(BR.item, item)
    }
}
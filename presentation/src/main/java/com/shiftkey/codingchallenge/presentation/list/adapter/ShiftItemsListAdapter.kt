package com.shiftkey.codingchallenge.presentation.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.shiftkey.codingchallenge.domain.model.ShiftItem
import com.shiftkey.codingchallenge.presentation.databinding.ViewShiftItemBinding
import javax.inject.Inject

class ShiftItemsListAdapter @Inject constructor(
    diffCallback: ShiftDiffCallback,
) : ListAdapter<ShiftItem, ShiftItemViewHolder>(diffCallback) {

    var onItemClickListener: (Long) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShiftItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewDataBinding = ViewShiftItemBinding.inflate(inflater, parent, false)
        val result = ShiftItemViewHolder(viewDataBinding)
        viewDataBinding.root.setOnClickListener { onItemClickListener(getItem(result.adapterPosition).shiftId) }
        return result
    }

    override fun onBindViewHolder(holder: ShiftItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
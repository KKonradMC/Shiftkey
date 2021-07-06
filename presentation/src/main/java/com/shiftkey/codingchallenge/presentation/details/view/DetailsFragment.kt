package com.shiftkey.codingchallenge.presentation.details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.shiftkey.codingchallenge.presentation.base.view.BaseFragment
import com.shiftkey.codingchallenge.presentation.databinding.FragmentDetailsBinding
import com.shiftkey.codingchallenge.presentation.details.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment :
    BaseFragment<DetailsViewModel, FragmentDetailsBinding>(DetailsViewModel::class.java) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onArgPassed(arguments?.getLong(SHIFT_ID) ?: error("Please pass shift id"))
    }

    override fun crateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentDetailsBinding = FragmentDetailsBinding.inflate(inflater, container, false)
}

private const val SHIFT_ID = "shift_id"

@BindingAdapter("text", "param")
fun TextView.textParams(text: String, params: Long) {
    setText(String.format(text, params))
}
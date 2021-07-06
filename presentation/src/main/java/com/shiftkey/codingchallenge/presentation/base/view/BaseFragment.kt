package com.shiftkey.codingchallenge.presentation.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.shiftkey.codingchallenge.presentation.BR
import com.shiftkey.codingchallenge.presentation.base.viewmodel.BaseViewModel

abstract class BaseFragment<VIEW_MODEL : BaseViewModel, BINDING : ViewDataBinding>(
    private val clazz: Class<VIEW_MODEL>,
) : Fragment() {

    protected lateinit var viewModel: VIEW_MODEL

    protected lateinit var binding: BINDING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(clazz)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = crateBinding(inflater, container).apply {
        setVariable(BR.vm, viewModel)
        lifecycleOwner = viewLifecycleOwner
        binding = this
    }.root

    abstract fun crateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): BINDING
}
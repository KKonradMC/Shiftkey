package com.shiftkey.codingchallenge.presentation.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.shiftkey.codingchallenge.domain.model.ShiftItem
import com.shiftkey.codingchallenge.presentation.base.view.BaseFragment
import com.shiftkey.codingchallenge.presentation.databinding.FragmentListBinding
import com.shiftkey.codingchallenge.presentation.list.adapter.ShiftItemsListAdapter
import com.shiftkey.codingchallenge.presentation.list.viewmodel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : BaseFragment<ListViewModel, FragmentListBinding>(ListViewModel::class.java) {

    @Inject
    lateinit var adapter: ShiftItemsListAdapter

    override fun crateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentListBinding = FragmentListBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shiftsList.adapter = adapter
        adapter.onItemClickListener = ::onItemClick
    }

    private fun onItemClick(shiftId: Long) {
        val showDetailsNav = ListFragmentDirections.actionFromListFragmentToDetailsFragment(shiftId)
        findNavController().navigate(showDetailsNav)
    }
}

@BindingAdapter("submitShiftList")
fun RecyclerView.submitShiftList(shiftList: List<ShiftItem>?) {
    (adapter as? ShiftItemsListAdapter)?.submitList(shiftList)
}

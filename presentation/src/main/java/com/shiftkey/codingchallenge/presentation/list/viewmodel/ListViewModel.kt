package com.shiftkey.codingchallenge.presentation.list.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.shiftkey.codingchallenge.domain.model.ShiftItem
import com.shiftkey.codingchallenge.domain.usecase.GetAvailableShiftsUseCase
import com.shiftkey.codingchallenge.presentation.base.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getAvailableShiftsUseCase: GetAvailableShiftsUseCase,
) : BaseViewModel() {

    val shiftList = MutableLiveData<List<ShiftItem>>()

    init {
        fetchData(Date())
    }

    private fun fetchData(date: Date) {
        getAvailableShiftsUseCase(date)
            .subscribe({ items -> shiftList.value = items })
            { error -> Log.e(ListViewModel::class.java.simpleName, "Error", error) }
            .disposeAutomatically()
    }
}
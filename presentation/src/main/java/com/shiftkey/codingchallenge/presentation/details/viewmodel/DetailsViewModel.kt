package com.shiftkey.codingchallenge.presentation.details.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.shiftkey.codingchallenge.domain.usecase.GetShiftDetailsUseCase
import com.shiftkey.codingchallenge.presentation.base.viewmodel.BaseViewModel
import com.shiftkey.codingchallenge.presentation.list.viewmodel.ListViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getShiftDetailsUseCase: GetShiftDetailsUseCase,
) : BaseViewModel() {
    val shiftId = MutableLiveData<Long>()
    val startTime = MutableLiveData<String>()
    val endTime = MutableLiveData<String>()
    val premiumRate = MutableLiveData<Boolean>()
    val covid = MutableLiveData<Boolean>()
    val shiftKind = MutableLiveData<String>()
    val facilityTypeName = MutableLiveData<String>()
    val facilityTypeColor = MutableLiveData<Int>()
    val skillName = MutableLiveData<String>()
    val skillColor = MutableLiveData<Int>()
    val localizedName = MutableLiveData<String>()
    val localizedColor = MutableLiveData<Int>()

    fun onArgPassed(id: Long) {
        getShiftDetailsUseCase(id)
            .subscribe({
                shiftId.value = it.shiftId
                startTime.value = it.startTime
                endTime.value = it.endTime
                premiumRate.value = it.premiumRate
                covid.value = it.covid
                shiftKind.value = it.shiftKind
                facilityTypeName.value = it.facilityTypeName
                facilityTypeColor.value = it.facilityTypeColor
                skillName.value = it.skillName
                skillColor.value = it.skillColor
                localizedName.value = it.localizedName
                localizedColor.value = it.localizedColor
            })
            { error -> Log.e(ListViewModel::class.java.simpleName, "Error", error) }
            .disposeAutomatically()
    }
}

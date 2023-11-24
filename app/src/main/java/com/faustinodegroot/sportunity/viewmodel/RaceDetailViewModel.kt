package com.faustinodegroot.sportunity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faustinodegroot.sportunity.domain.model.Race
import com.faustinodegroot.sportunity.domain.usecase.RaceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RaceDetailViewModel @Inject constructor(
    private val raceUseCase: RaceUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _raceLiveData = MutableLiveData<Race?>()
    val raceLiveData: MutableLiveData<Race?> = _raceLiveData

    private var raceId: Int
    private var eventId: Int

    init {
        raceId = savedStateHandle["raceId"] ?: -1
        eventId = savedStateHandle["eventId"] ?: -1
        getRace()

    }

    private fun getRace() {
        if (raceId != -1 && eventId != -1) {
            viewModelScope.launch {
                try {
                    val raceResponse = raceUseCase.getRace(eventId, raceId)

                    if (raceResponse != null) {
                        _raceLiveData.value = raceResponse
                    }
                } catch (_: Exception) {

                }
            }
        }
    }

}

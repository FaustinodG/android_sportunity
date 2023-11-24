package com.faustinodegroot.sportunity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.faustinodegroot.sportunity.domain.model.Event
import com.faustinodegroot.sportunity.domain.usecase.EventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EventListViewModel @Inject constructor(
    eventsUseCase: EventsUseCase
) : ViewModel() {

    val eventsList: LiveData<PagingData<Event>> =
        eventsUseCase.getEvents()
            .cachedIn(viewModelScope)

}

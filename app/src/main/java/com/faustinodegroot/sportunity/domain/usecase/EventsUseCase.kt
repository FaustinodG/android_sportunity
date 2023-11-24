package com.faustinodegroot.sportunity.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.faustinodegroot.sportunity.domain.model.Event
import com.faustinodegroot.sportunity.domain.model.Race
import com.faustinodegroot.sportunity.domain.repository.EventsRepository
import javax.inject.Inject

class EventsUseCase @Inject constructor(private val repository: EventsRepository) :
    BaseUseCase<Event> {

    fun getEvents(): LiveData<PagingData<Event>> {
        return repository.getEvents()
    }

    override suspend fun getAll(): List<Event> {
        TODO("Not yet implemented")
    }

    override suspend fun getById(id: Int): Event {
        TODO("Not yet implemented")
    }

    override suspend fun delete(entity: Event) {
        TODO("Not yet implemented")
    }

    override suspend fun update(entity: Event) {
        TODO("Not yet implemented")
    }

    override suspend fun add(entity: Event) {
        TODO("Not yet implemented")
    }

    override suspend fun addAll(entity: List<Event>) {
        TODO("Not yet implemented")
    }

}

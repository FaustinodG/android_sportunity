package com.faustinodegroot.sportunity.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.faustinodegroot.sportunity.domain.repository.paging.EventPagingDataSource
import com.faustinodegroot.sportunity.domain.model.Event
import com.faustinodegroot.sportunity.network.service.EventsService
import javax.inject.Inject

class EventsRepository @Inject constructor(private val eventsService: EventsService) : BaseRepository<Event> {

    fun getEvents(): LiveData<PagingData<Event>> {
        return Pager(
            config = PagingConfig(
                pageSize = 15,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                EventPagingDataSource(eventsService)
            }
        ).liveData
    }

    override suspend fun getById(id: Int): Event {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<Event> {
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

    override suspend fun addAll(entities: List<Event>) {
        TODO("Not yet implemented")
    }
}

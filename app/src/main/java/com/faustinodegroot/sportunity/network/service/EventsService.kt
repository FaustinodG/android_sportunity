package com.faustinodegroot.sportunity.network.service

import com.faustinodegroot.sportunity.network.response.EventListResponse
import com.faustinodegroot.sportunity.network.api.EventsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EventsService @Inject constructor(private val eventsApi: EventsApi) : BaseService<EventListResponse> {

    suspend fun getEventsByPage(currentPage: Int): EventListResponse {
        return withContext(Dispatchers.IO) {
            val events = eventsApi.getEventsByPage(currentPage = currentPage)
            events.body() ?: EventListResponse()
        }
    }

    override suspend fun getAll(): EventListResponse {
        return withContext(Dispatchers.IO) {
            val events = eventsApi.getEventsByPage(currentPage = 1)
            events.body() ?: EventListResponse()
        }
    }
}

package com.faustinodegroot.sportunity.network.api

import com.faustinodegroot.sportunity.network.response.EventListResponse
import com.faustinodegroot.sportunity.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EventsApi {

    @GET(Constants.EVENTS_ENDPOINT)
    suspend fun getEventsByPage(
        @Query("include") include: String = Constants.INCLUDE_RACES,
        @Query("filters") filters: String = Constants.FILTERS,
        @Query("page") currentPage: Int
    ): Response<EventListResponse>
}

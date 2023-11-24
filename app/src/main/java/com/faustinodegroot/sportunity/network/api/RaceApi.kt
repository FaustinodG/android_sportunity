package com.faustinodegroot.sportunity.network.api

import com.faustinodegroot.sportunity.domain.model.Race
import com.faustinodegroot.sportunity.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RaceApi {

    @GET(Constants.RACE_ENDPOINT)
    suspend fun getRace(
        @Path("eventId")eventId: Int,
        @Path("raceId")raceId: Int,
        @Query("include")include: String = Constants.INCLUDE_ROUTE
    ): Response<Race>
}

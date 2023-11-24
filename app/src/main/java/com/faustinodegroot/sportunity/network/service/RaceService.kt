package com.faustinodegroot.sportunity.network.service

import com.faustinodegroot.sportunity.domain.model.Race
import com.faustinodegroot.sportunity.network.api.RaceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RaceService @Inject constructor(private val raceApi: RaceApi): BaseService<Race> {

    override suspend fun getAll(): Race {
        TODO("Not yet implemented")
    }

    suspend fun getRace(eventId: Int, raceId: Int): Race {
        return withContext(Dispatchers.IO) {
            val events = raceApi.getRace(eventId, raceId)
            events.body() ?: Race()
        }
    }
}

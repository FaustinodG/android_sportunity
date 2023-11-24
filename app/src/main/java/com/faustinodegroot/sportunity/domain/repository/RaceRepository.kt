package com.faustinodegroot.sportunity.domain.repository

import com.faustinodegroot.sportunity.domain.model.Race
import com.faustinodegroot.sportunity.network.service.RaceService
import javax.inject.Inject

class RaceRepository @Inject constructor(private val raceService: RaceService) : BaseRepository<Race> {

    suspend fun getRace(eventId: Int, raceId: Int) : Race? {
        return raceService.getRace(eventId, raceId)
    }

    override suspend fun getById(id: Int): Race {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<Race> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(entity: Race) {
        TODO("Not yet implemented")
    }

    override suspend fun update(entity: Race) {
        TODO("Not yet implemented")
    }

    override suspend fun add(entity: Race) {
        TODO("Not yet implemented")
    }

    override suspend fun addAll(entities: List<Race>) {
        TODO("Not yet implemented")
    }
}

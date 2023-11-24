package com.faustinodegroot.sportunity.domain.usecase

import com.faustinodegroot.sportunity.domain.model.Race
import com.faustinodegroot.sportunity.domain.repository.RaceRepository
import javax.inject.Inject

class RaceUseCase @Inject constructor(private val raceRepository: RaceRepository) : BaseUseCase<Race> {

    suspend fun getRace(eventId: Int, raceId: Int): Race? {
        return raceRepository.getRace(eventId, raceId)
    }

    override suspend fun getAll(): List<Race> {
        TODO("Not yet implemented")
    }

    override suspend fun getById(id: Int): Race {
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

    override suspend fun addAll(entity: List<Race>) {
        TODO("Not yet implemented")
    }
}

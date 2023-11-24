package com.faustinodegroot.sportunity.domain.usecase

interface BaseUseCase<T>  {
    suspend fun getAll(): List<T>

    suspend fun getById(id: Int): T

    suspend fun addAll(entity: List<T>)

    suspend fun add(entity: T)

    suspend fun update(entity: T)

    suspend fun delete(entity: T)

}

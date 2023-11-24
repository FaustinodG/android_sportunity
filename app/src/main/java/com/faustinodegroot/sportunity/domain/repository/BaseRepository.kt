package com.faustinodegroot.sportunity.domain.repository


interface BaseRepository<T> {
    suspend fun getById(id: Int): T
    suspend fun getAll(): List<T>
    suspend fun addAll(entities: List<T>)
    suspend fun add(entity: T)
    suspend fun update(entity: T)
    suspend fun delete(entity: T)
}

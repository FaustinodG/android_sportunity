package com.faustinodegroot.sportunity.network.service

interface BaseService<T> {
    suspend fun getAll(): T
}

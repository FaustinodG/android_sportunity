package com.faustinodegroot.sportunity.di

import com.faustinodegroot.sportunity.domain.repository.paging.EventPagingDataSource
import com.faustinodegroot.sportunity.domain.model.Event
import com.faustinodegroot.sportunity.domain.model.Race
import com.faustinodegroot.sportunity.util.Constants
import com.faustinodegroot.sportunity.domain.repository.BaseRepository
import com.faustinodegroot.sportunity.domain.repository.EventsRepository
import com.faustinodegroot.sportunity.domain.repository.RaceRepository
import com.faustinodegroot.sportunity.domain.usecase.EventsUseCase
import com.faustinodegroot.sportunity.domain.usecase.RaceUseCase
import com.faustinodegroot.sportunity.network.api.EventsApi
import com.faustinodegroot.sportunity.network.api.RaceApi
import com.faustinodegroot.sportunity.network.service.EventsService
import com.faustinodegroot.sportunity.network.service.RaceService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideEventsApi(retrofit: Retrofit): EventsApi {
        return retrofit.create(EventsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideEventsService(eventsApi: EventsApi): EventsService {
        return EventsService(eventsApi)
    }

    @Provides
    @Singleton
    fun provideEventPagingDataSource(eventsService: EventsService) : EventPagingDataSource {
        return EventPagingDataSource(eventsService)
    }

    @Provides
    @Singleton
    fun provideEventsRepository(eventsService: EventsService): BaseRepository<Event> {
        return EventsRepository(eventsService)
    }

    @Provides
    @Singleton
    fun provideEventsUseCase(eventsRepository: EventsRepository): EventsUseCase {
        return EventsUseCase(eventsRepository)
    }

    @Provides
    @Singleton
    fun provideRaceApi(retrofit: Retrofit): RaceApi {
        return retrofit.create(RaceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRaceService(raceApi: RaceApi): RaceService {
        return RaceService(raceApi)
    }

    @Provides
    @Singleton
    fun providesRaceRepository(raceService: RaceService) : BaseRepository<Race> {
        return RaceRepository(raceService)
    }

    @Provides
    @Singleton
    fun provideRaceUseCase(raceRepository: RaceRepository): RaceUseCase {
        return RaceUseCase(raceRepository)
    }


}

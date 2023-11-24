package com.faustinodegroot.sportunity.domain.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.faustinodegroot.sportunity.domain.model.Event
import com.faustinodegroot.sportunity.network.service.EventsService
import timber.log.Timber
import javax.inject.Inject

class EventPagingDataSource @Inject constructor(private val eventsService: EventsService) : PagingSource<Int, Event>() {

    override fun getRefreshKey(state: PagingState<Int, Event>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Event> {
        val page = params.key ?: PAGING_INDEX_START
        return try {
            val response = eventsService.getEventsByPage(page)
            LoadResult.Page(
                data = response.events,
                prevKey = if (response.meta.pagination.currentPage == PAGING_INDEX_START) null else page - 1,
                nextKey = if (response.meta.pagination.links.next != null) page + 1 else null
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }

    }

    companion object {
        const val PAGING_INDEX_START = 1
    }
}

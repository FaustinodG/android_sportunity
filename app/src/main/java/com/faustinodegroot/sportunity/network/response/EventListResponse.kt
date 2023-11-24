package com.faustinodegroot.sportunity.network.response

import com.faustinodegroot.sportunity.domain.model.Event
import com.google.gson.annotations.SerializedName

data class EventListResponse(
    @SerializedName("meta") var meta: Meta = Meta(),
    @SerializedName("items") var events: List<Event> = listOf()
)

data class Meta(
    @SerializedName("pagination") var pagination: Pagination = Pagination(),
    @SerializedName("filters") var filters: List<Filters>? = null

)

data class Filters(
    @SerializedName("state") var state: List<String> = listOf(),
    @SerializedName("date_after") var dateAfter: String? = null

)

data class Pagination(

    @SerializedName("total") var total: Int? = null,
    @SerializedName("count") var count: Int? = null,
    @SerializedName("per_page") var perPage: Int? = null,
    @SerializedName("current_page") var currentPage: Int = 0,
    @SerializedName("total_pages") var totalPages: Int = 0,
    @SerializedName("links") var links: Links = Links()

)

data class Links(

    @SerializedName("next") var next: String? = null,
    @SerializedName("previous") var previous: String? = null

)

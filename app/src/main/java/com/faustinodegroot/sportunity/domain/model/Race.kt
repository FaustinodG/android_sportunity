package com.faustinodegroot.sportunity.domain.model

import com.google.gson.annotations.SerializedName

data class Race(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("name") var name: String? = null,
    @SerializedName("start") var start: String? = null,
    @SerializedName("distance") var distance: Double? = null,
    @SerializedName("state") var state: String? = null,
    @SerializedName("sport") var sport: String? = null,
    @SerializedName("participant_amount_expected") var participantAmountExpected: String? = null,
    @SerializedName("participant_count") var participantCount: Int? = null,
    @SerializedName("start_type") var startType: String? = null,
    @SerializedName("statistics") var statistics: Statistic? = Statistic(),
    @SerializedName("timetable") var timetable: TimetableList? = TimetableList(),
    @SerializedName("route") var route: Route = Route()
)

data class TimetableList(
    @SerializedName("icon") var icon: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("published") var published: Boolean? = null,
    @SerializedName("timetable") var timetable: List<Timetable> = listOf()
)

data class Timetable(
    @SerializedName("icon") var icon: String? = null,
    @SerializedName("time") var time: String? = null,
    @SerializedName("index") var index: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("subtitle") var subtitle: String? = null
)


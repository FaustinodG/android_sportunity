package com.faustinodegroot.sportunity.domain.model

import com.google.gson.annotations.SerializedName

data class Statistic(
    @SerializedName("total_participants_count") var totalParticipantsCount: Int? = null,
    @SerializedName("male_participants_count") var maleParticipantsCount: Int? = null,
    @SerializedName("female_participants_count") var femaleParticipantsCount: Int? = null,
    @SerializedName("male_record") var maleRecord: String? = null,
    @SerializedName("female_record") var femaleRecord: String? = null,
    @SerializedName("average_age") var averageAge: Int? = null
)

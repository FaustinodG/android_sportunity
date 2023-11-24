package com.faustinodegroot.sportunity.domain.model

import com.google.gson.annotations.SerializedName

data class Route(
    @SerializedName("type") var type: String? = null,
    @SerializedName("features") var features: List<Features> = listOf()
)

data class Features(
    @SerializedName("type") var type: String? = null,
    @SerializedName("geometry") var geometry: Geometry = Geometry(),
    @SerializedName("properties") var properties: Properties? = Properties()
)

data class Properties(
    @SerializedName("name") var name: String? = null

)

data class Geometry(
    @SerializedName("type") var type: String? = null,
    @SerializedName("coordinates") var coordinates: List<List<Double>> = listOf()
)

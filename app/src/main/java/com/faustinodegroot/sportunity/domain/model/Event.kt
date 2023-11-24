package com.faustinodegroot.sportunity.domain.model

import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("logo_url") var logoUrl: String? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("date_from") var dateFrom: String,
    @SerializedName("date_to") var dateTo: String,
    @SerializedName("start_time") var startTime: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("state") var state: String? = null,
    @SerializedName("all_sports") var allSports: List<String> = listOf(),
    @SerializedName("participant_amount_expected") var participantAmountExpected: Int? = null,
    @SerializedName("city") var city: String? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("postal_code") var postalCode: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("street") var street: String? = null,
    @SerializedName("house_number") var houseNumber: String? = null,
    @SerializedName("distance_units") var distanceUnits: String? = null,
    @SerializedName("temperature_units") var temperatureUnits: String? = null,
    @SerializedName("tracking_image_url") var trackingImageUrl: String? = null,
    @SerializedName("live_tracking_title") var liveTrackingTitle: String? = null,
    @SerializedName("live_tracking_text") var liveTrackingText: String? = null,
    @SerializedName("color_primary") var colorPrimary: String? = null,
    @SerializedName("color_secondary") var colorSecondary: String? = null,
    @SerializedName("custom_website_colorscheme") var customWebsiteColorscheme: String? = null,
    @SerializedName("timeline_welcome_image_url") var timelineWelcomeImageUrl: String? = null,
    @SerializedName("timeline_welcome_title") var timelineWelcomeTitle: String? = null,
    @SerializedName("timeline_welcome_text") var timelineWelcomeText: String? = null,
    var races: List<Race> = listOf()
)

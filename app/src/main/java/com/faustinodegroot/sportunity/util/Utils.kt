package com.faustinodegroot.sportunity.util

import com.google.android.gms.maps.model.LatLng
import timber.log.Timber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {

    fun formatDate(dateString: String): String? {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'", Locale.US)

        var date: Date? = null
        try {
            date = inputFormat.parse(dateString)
        } catch (e: ParseException) {
            Timber.e(e)
        }

        val outputFormat = SimpleDateFormat("EEEE d MMMM yyyy", Locale.US)

        return date?.let { outputFormat.format(it) }
    }

    fun formatDistance(distance: Double): String =
        (distance / 1000.0).let { String.format(if (it % 1 == 0.0) "%.0f" else "%.2f", it) } + " KM"

    fun createLatLng(coordinate: List<Double>): LatLng {
        return LatLng(coordinate[0], coordinate[1])
    }
}

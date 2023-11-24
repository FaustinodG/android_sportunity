package com.faustinodegroot.sportunity.util

import org.junit.Assert.assertEquals

import org.junit.Test

class UtilsTest {

    @Test
    fun `should return formatted date`(){
        val dateString = "2022-06-19T05:00:00.000000Z"
        val actualDate = "Sunday 19 June 2022"
        val formattedDate = Utils.formatDate(dateString)
        assertEquals(formattedDate,actualDate)
    }

    @Test
    fun `should omit values after decimal`(){
        val distanceInMeters = 1000.00
        val expectedValue = "1 KM"
        val formattedDistance = Utils.formatDistance(distanceInMeters)
        assertEquals(formattedDistance, expectedValue)
    }

    @Test
    fun `should not omit values after decimal`(){
        val distanceInMeters = 1350.00
        val expectedValue = "1,35 KM"
        val formattedDistance = Utils.formatDistance(distanceInMeters)
        assertEquals(formattedDistance, expectedValue)
    }

}

package com.faustinodegroot.sportunity.viewmodel

import com.faustinodegroot.sportunity.domain.usecase.RaceUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito


class RaceDetailViewModelTest {

    private lateinit var raceUseCase: RaceUseCase

    @Before
    fun setUp() {
        raceUseCase = Mockito.mock(RaceUseCase::class.java)
    }

    @Test
    fun `race name should be 'Bartje 200'`() = runBlocking{
        val race = raceUseCase.getRace(2,7)
        if (race != null) {
            Assert.assertEquals(race.name, "Bartje 200")
        }
    }
}

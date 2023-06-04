package com.jocmp.revcal.lib

import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RevDateTest {
    @Test
    fun `Test Coup of 18 Brumaire`() {
        val date = RevDate.fromGregorian(LocalDate.of(1799, 11, 9))
        val expected = RevDate(8, RevMonth.BRUMAIRE, 18)

        assertEquals(expected, date)
    }

    @Test
    fun `Test July Revolution`() {
        val date = RevDate.fromGregorian(LocalDate.of(1830, 7, 26))
        val expected = RevDate(38, RevMonth.THERMIDOR, 7)

        assertEquals(expected, date)
    }

    @Test
    fun `Test election of Napolean III`() {
        // https://en.wikipedia.org/wiki/1851_French_coup_d%27%C3%A9tat
        val date = RevDate.fromGregorian(LocalDate.of(1851, 12, 2))
        val expected = RevDate(60, RevMonth.FRIMAIRE, 11)

        assertEquals(expected, date)
    }
}

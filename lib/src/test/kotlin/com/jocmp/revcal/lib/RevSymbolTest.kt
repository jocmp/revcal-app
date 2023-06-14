package com.jocmp.revcal.lib

import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RevSymbolTest {
    @Test
    fun `Test serialization`() {
        val symbol = RevSymbol.all[194]

        assertEquals("bee", symbol.id)
        assertEquals("Abeille", symbol.frenchName)
        assertEquals("Bee", symbol.name)
    }
}

package com.jocmp.revcal.lib

enum class RevMonth(val value: String) {
    VENDEMIAIRE("Vendémiaire"),
    BRUMAIRE("Brumaire"),
    FRIMAIRE("Frimaire"),
    NIVOSE("Nivôse"),
    PLUVIOSE("Pluviose"),
    VENTOSE("Ventôse"),
    GERMINAL("Germinal"),
    FLOREAL("Floréal"),
    PRAIRIAL("Prairial"),
    MESSIDOR("Messidor"),
    THERMIDOR("Thermidor"),
    FRUCTIDOR("Fructidor"),
    SANSCULOTTIDES("Sansculottides");

    companion object {
        fun from(month: Int): RevMonth {
            return RevMonth.values()[month - 1]
        }
    }
}

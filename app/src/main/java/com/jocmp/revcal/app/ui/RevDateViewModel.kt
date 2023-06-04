package com.jocmp.revcal.app.ui

import java.time.LocalDate

data class RevDateViewModel(
    val goToNextDay: () -> Unit = {},
    val goToPreviousDay: () -> Unit = {},
    val jumpToDay: (day: LocalDate) -> Unit = {},
    val description: String = "",
    val day: LocalDate,
)

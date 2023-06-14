package com.jocmp.revcal.app.ui

import java.time.LocalDate

data class HomeViewModel(
    val isPreviousDayEnabled: Boolean = true,
    val goToNextDay: () -> Unit = {},
    val goToPreviousDay: () -> Unit = {},
    val jumpToDay: (day: LocalDate) -> Unit = {},
    val day: LocalDate,
    val description: String = "",
    val image: String? = null
)

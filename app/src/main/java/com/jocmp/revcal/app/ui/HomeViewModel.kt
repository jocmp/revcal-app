package com.jocmp.revcal.app.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import com.jocmp.revcal.client.Symbol
import java.time.LocalDate

@OptIn(ExperimentalFoundationApi::class)
data class HomeViewModel(
    val isLoading: Boolean = true,
    val isPreviousDayEnabled: Boolean = true,
    val goToNextDay: () -> Unit = {},
    val goToPreviousDay: () -> Unit = {},
    val jumpToDay: (day: LocalDate) -> Unit = {},
    val day: LocalDate,
    val currentIndex: Int = -1,
    val symbols: List<Symbol> = emptyList(),
    val description: String = ""
)

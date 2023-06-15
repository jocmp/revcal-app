package com.jocmp.revcal.app.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import com.jocmp.revcal.app.R
import com.jocmp.revcal.app.lib.Async
import com.jocmp.revcal.client.Symbol
import com.jocmp.revcal.lib.RevDate
import com.jocmp.revcal.lib.RevDate.Companion.FIRST_REPUBLICAN_GREGORIAN_DAY
import com.jocmp.revcal.lib.RevDate.Companion.FIRST_REPUBLICAN_GREGORIAN_MONTH
import com.jocmp.revcal.lib.RevDate.Companion.FIRST_REPUBLICAN_GREGORIAN_YEAR
import java.time.LocalDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun useHomeViewModel(currentDate: LocalDate = LocalDate.now()): HomeViewModel {
    val (day, setDay) = rememberSaveable { mutableStateOf(currentDate) }

    val (symbols, loading) = when (val data = useSymbols()) {
        is Async.Success -> Pair(data(), false)
        else -> Pair(emptyList(), true)
    }

    fun nextDay() {
        setDay(day.plusDays(1))
    }

    fun jumpToDay(selected: LocalDate) {
        if (selected.isBefore(lowerBoundDay)) {
            setDay(lowerBoundDay)
        } else {
            setDay(selected)
        }
    }

    fun previousDay() {
        jumpToDay(day.minusDays(1))
    }

    val defaultModel = HomeViewModel(
        isPreviousDayEnabled = day.isAfter(lowerBoundDay),
        goToNextDay = { nextDay() },
        goToPreviousDay = { previousDay() },
        jumpToDay = { jumpToDay(it) },
        day = day,
        isLoading = loading
    )

    if (loading) {
        return defaultModel
    }

    val revDate = RevDate.fromGregorian(day)
    val currentIndex = findSymbolIndex(revDate)

    return defaultModel.copy(
        description =  formatRevDate(day, revDate, symbols[currentIndex]),
        symbols = symbols,
        currentIndex = currentIndex
    )
}

/**
 * So we have arranged in the column of each month,
 * the names of the real treasures of the rural economy.
 *             - Fabregi d'Églantine
 */
private fun findSymbolIndex(revDate: RevDate): Int {
    return 30 * revDate.month.ordinal + (revDate.day - 1)
}

private val lowerBoundDay: LocalDate = LocalDate.of(
    FIRST_REPUBLICAN_GREGORIAN_YEAR,
    FIRST_REPUBLICAN_GREGORIAN_MONTH,
    FIRST_REPUBLICAN_GREGORIAN_DAY
)

@Composable
fun formatRevDate(day: LocalDate, revDate: RevDate, symbol: Symbol): String {
    val formattedDate = stringResource(
        R.string.formatted_day,
        revDate.day,
        revDate.month.value,
        revDate.year
    )

    return if (day.isEqual(LocalDate.now())) {
        stringResource(
            R.string.current_day_celebration,
            formattedDate,
            symbol.name
        )
    } else {
        stringResource(
            R.string.other_day_celebration,
            formattedDate,
            symbol.name
        )
    }
}

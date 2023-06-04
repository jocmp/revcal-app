package com.jocmp.revcal.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import com.jocmp.revcal.app.R
import com.jocmp.revcal.lib.RevDate
import com.jocmp.revcal.lib.RevDate.Companion.FIRST_REPUBLICAN_GREGORIAN_DAY
import com.jocmp.revcal.lib.RevDate.Companion.FIRST_REPUBLICAN_GREGORIAN_MONTH
import com.jocmp.revcal.lib.RevDate.Companion.FIRST_REPUBLICAN_GREGORIAN_YEAR
import java.time.LocalDate

@Composable
fun useRevDate(currentDate: LocalDate = LocalDate.now()): RevDateViewModel {
    val (day, setDay) = rememberSaveable { mutableStateOf(currentDate) }

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

    return RevDateViewModel(
        isPreviousDayEnabled = day.isAfter(lowerBoundDay),
        goToNextDay = { nextDay() },
        goToPreviousDay = { previousDay() },
        jumpToDay = { jumpToDay(it) },
        day = day,
        description = formatRevDate(day)
    )
}

private val lowerBoundDay: LocalDate = LocalDate.of(
    FIRST_REPUBLICAN_GREGORIAN_YEAR,
    FIRST_REPUBLICAN_GREGORIAN_MONTH,
    FIRST_REPUBLICAN_GREGORIAN_DAY
)

@Composable
fun formatRevDate(day: LocalDate): String {
    val revDate = RevDate.fromGregorian(day)

    val formattedDate = stringResource(
        R.string.formatted_day,
        revDate.day,
        revDate.month.value,
        revDate.year
    )

    return if (day.isEqual(LocalDate.now())) {
        stringResource(
            R.string.current_day,
            formattedDate,
            revDate.symbol.name.english
        )
    } else {
        stringResource(
            R.string.other_day,
            formattedDate,
            revDate.symbol.name.english
        )
    }
}

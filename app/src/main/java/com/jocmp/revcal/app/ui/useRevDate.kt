package com.jocmp.revcal.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import com.jocmp.revcal.app.R
import com.jocmp.revcal.lib.RevDate
import java.time.LocalDate

@Composable
fun useRevDate(currentDate: LocalDate = LocalDate.now()): RevDateViewModel {
    val (day, setDay) = rememberSaveable { mutableStateOf(currentDate) }

    fun nextDay() {
        setDay(day.plusDays(1))
    }

    fun previousDay() {
        setDay(day.minusDays(1))
    }

    fun jumpToDay(selected: LocalDate) {
        setDay(selected)
    }

    return RevDateViewModel(
        goToNextDay = { nextDay() },
        goToPreviousDay = { previousDay() },
        jumpToDay = { jumpToDay(it) },
        day = day,
        description = formatRevDate(day)
    )
}

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

package com.jocmp.revcal.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jocmp.revcal.app.R
import com.jocmp.revcal.app.ui.theme.RevCalTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

@Composable
fun DateSelector(
    goToPreviousDay: () -> Unit = {},
    goToNextDay: () -> Unit = {},
    jumpToDay: (day: LocalDate) -> Unit = {},
    isPreviousDayEnabled: Boolean = true,
    day: LocalDate,
) {
    val text = day.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))

    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FilledIconButton(
                enabled = isPreviousDayEnabled,
                onClick = { goToPreviousDay() }
            ) {
                Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = stringResource(R.string.date_selector_choose_previous))
            }
            DateDialog(
                startDate = StartDate(value = day, text = text),
                onSelect = { jumpToDay(it) }
            )
            FilledIconButton(
                onClick = { goToNextDay() }
            ) {
                Icon(Icons.Filled.KeyboardArrowRight, contentDescription = stringResource(R.string.date_selector_choose_next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DateSelectorPreview() {
    RevCalTheme {
        DateSelector(day = LocalDate.now())
    }
}

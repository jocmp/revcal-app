package com.jocmp.revcal.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jocmp.revcal.app.ui.theme.RevCalTheme
import java.time.LocalDate

@Composable
fun DatePager(
    goToPreviousDay: () -> Unit = {},
    goToNextDay: () -> Unit = {},
    jumpToDay: (day: LocalDate) -> Unit = {},
    day: LocalDate,
) {
    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                goToPreviousDay()
            }) {
                Text("-")
            }
            DateDialog(
                startDate = day,
                onSelect = { jumpToDay(it) }
            )
            Button(onClick = {
                goToNextDay()
            }) {
                Text("+")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RevCalTheme {
        DatePager(day = LocalDate.now())
    }
}

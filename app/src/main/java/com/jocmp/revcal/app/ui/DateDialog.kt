package com.jocmp.revcal.app.ui

import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.jocmp.revcal.lib.RevDate
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateDialog(
    startDate: LocalDate,
    onSelect: (date: LocalDate) -> Unit,
) {
    val (isOpen, setOpen) = remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = startDate.toEpochMilli(),
        yearRange = yearRange
    )

    Button(onClick = { setOpen(true) }) {
        Text(text = startDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)))
    }

    if (isOpen) {
        val confirmEnabled = datePickerState.selectedDateMillis != null

        DatePickerDialog(
            onDismissRequest = {
                setOpen(false)
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let {
                            onSelect(it.toLocalDate())
                        }

                        setOpen(false)
                    },
                    enabled = confirmEnabled
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { setOpen(false) }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}

// Choose the first full Gregorian year of the Republic
val yearRange = IntRange(RevDate.FIRST_REPUBLICAN_GREGORIAN_YEAR + 1, 2100)

private fun LocalDate.toEpochMilli(): Long {
    return this.atStartOfDay(ZoneId.systemDefault())
        .toInstant()
        .toEpochMilli()
}

private fun Long.toLocalDate(): LocalDate {
    return Instant.ofEpochMilli(this).atZone(ZoneId.of("GMT")).toLocalDate()
}

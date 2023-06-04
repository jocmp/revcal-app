package com.jocmp.revcal.app.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeLayout() {
    val viewModel = useRevDate()

    Column {
        Text(text = viewModel.description)
        DatePager(
            day = viewModel.day,
            goToPreviousDay = { viewModel.goToPreviousDay() },
            goToNextDay = { viewModel.goToNextDay() },
            jumpToDay = { viewModel.jumpToDay(it) },
            isPreviousDayEnabled = viewModel.isPreviousDayEnabled
        )
    }
}

package com.jocmp.revcal.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jocmp.revcal.app.ui.theme.RevCalTheme
import java.time.LocalDate

@Composable
fun HomeLayout(viewModel: RevDateViewModel = useRevDate()) {
    Column(
        Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(text = viewModel.description)

        DateSelector(
            day = viewModel.day,
            goToPreviousDay = { viewModel.goToPreviousDay() },
            goToNextDay = { viewModel.goToNextDay() },
            jumpToDay = { viewModel.jumpToDay(it) },
            isPreviousDayEnabled = viewModel.isPreviousDayEnabled
        )
        Spacer(Modifier.height(48.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeLayoutPreview() {
    val viewModel = RevDateViewModel(
        day = LocalDate.of(2023, 6, 4)
    )
    RevCalTheme {
        HomeLayout(viewModel)
    }
}

package com.jocmp.revcal.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .height(500.dp)
                    .background(Color.Cyan)
            )
            Text(
                text = viewModel.description,
                textAlign = TextAlign.Center
            )
        }
        DateSelector(
            day = viewModel.day,
            goToPreviousDay = { viewModel.goToPreviousDay() },
            goToNextDay = { viewModel.goToNextDay() },
            jumpToDay = { viewModel.jumpToDay(it) },
            isPreviousDayEnabled = viewModel.isPreviousDayEnabled
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeLayoutPreview() {
    val viewModel = RevDateViewModel(
        description = "16 Vendemiaire 1 celebrates the four o'clock flower",
        day = LocalDate.of(1792, 10, 7)
    )
    RevCalTheme {
        HomeLayout(viewModel)
    }
}

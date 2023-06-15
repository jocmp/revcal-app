package com.jocmp.revcal.app.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jocmp.revcal.app.ui.theme.RevCalTheme
import java.time.LocalDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeLayout(viewModel: HomeViewModel = useHomeViewModel()) {
    Wrapper(loading = viewModel.isLoading) {
        SymbolPager(
            symbols = viewModel.symbols,
            initialPage = viewModel.currentIndex
        )
        Box(
            Modifier
                .fillMaxHeight(1 / 3f)
                .padding(bottom = 8.dp),
            contentAlignment = Alignment.BottomStart
        ) {
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

@Composable
fun Wrapper(loading: Boolean, content: @Composable() () -> Unit) {
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
            if (!loading) {
                content()
            }
        }
    }
}

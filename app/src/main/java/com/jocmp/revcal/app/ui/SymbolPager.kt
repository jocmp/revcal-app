package com.jocmp.revcal.app.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jocmp.revcal.client.Symbol

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SymbolPager(symbols: List<Symbol>, initialPage: Int) {
    val pagerState = rememberPagerState(initialPage = initialPage)

    HorizontalPager(pageCount = symbols.size, state = pagerState) { page ->
        Box(
            Modifier
                .height(500.dp)
                .aspectRatio(1f)
                .padding(bottom = 8.dp)
                .fillMaxWidth()
                .background(Color.Cyan)
        ) {
            AsyncImage(model = symbols[page].imageURL, contentDescription = null)
        }
    }
}

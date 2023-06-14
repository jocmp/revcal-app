package com.jocmp.revcal.app.ui

import androidx.compose.runtime.Composable
import com.jocmp.revcal.client.SymbolRepository

@Composable
fun useSymbols() = useRepositoryResource(fetch = {
    get<SymbolRepository>().all()
})

package com.jocmp.revcal.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import com.jocmp.revcal.app.lib.Async
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun <T> useRepositoryResource(fetch: suspend () -> Result<T>): Async<T> {
    val state = produceState<Async<T>>(initialValue = Async.Uninitialized) {
        value = Async.Loading
        withContext(Dispatchers.IO) {
            value = fetch().fold(
                onSuccess = { Async.Success(it) },
                onFailure = { Async.Failure(it) }
            )
        }
    }

    return state.value
}

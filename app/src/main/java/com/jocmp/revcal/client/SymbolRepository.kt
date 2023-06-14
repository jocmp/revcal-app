package com.jocmp.revcal.client

interface SymbolRepository {
    suspend fun all(): Result<List<Symbol>>
}

class DefaultSymbolRepository(private val client: RevcalClient) : SymbolRepository {
    override suspend fun all(): Result<List<Symbol>> {
        return request { client.listSymbols() }.fold(
            onSuccess = { result ->
                Result.success(result)
            },
            onFailure = { Result.failure(it) }
        )
    }
}

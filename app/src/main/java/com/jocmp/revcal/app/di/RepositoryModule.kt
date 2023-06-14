package com.jocmp.revcal.app.di

import com.jocmp.revcal.client.DefaultSymbolRepository
import com.jocmp.revcal.client.RevcalClient
import com.jocmp.revcal.client.SymbolRepository
import org.koin.dsl.module

internal val repositoryModule = module {
    single { RevcalClient.create() }
    single<SymbolRepository> { DefaultSymbolRepository(client = get()) }
}

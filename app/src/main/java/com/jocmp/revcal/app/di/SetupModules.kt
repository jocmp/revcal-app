package com.jocmp.revcal.app.di

import org.koin.core.KoinApplication

fun KoinApplication.setupModules() {
    modules(repositoryModule)
}

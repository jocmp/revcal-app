package com.jocmp.revcal.client

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RevcalClient {
    @GET("revcal/index.json")
    suspend fun listSymbols(): List<Symbol>

    companion object {
        fun create(baseURL: String = DEFAULT_URL): RevcalClient {
            val moshi = Moshi.Builder().build()

            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create()
        }
    }
}

const val DEFAULT_URL = "https://jocmp.com"

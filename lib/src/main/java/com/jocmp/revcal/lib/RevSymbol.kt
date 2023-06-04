package com.jocmp.revcal.lib

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter

@JsonClass(generateAdapter = true)
data class RevSymbol(val id: String, val name: RevSymbolNames, val description: String?) {
    companion object {
        @OptIn(ExperimentalStdlibApi::class)
        val all: List<RevSymbol> by lazy {
            val resource = RevSymbol::class.java.classLoader.getResource("symbols.json")
            val json = resource?.readText().toString()

            if (json.isBlank()) {
                return@lazy emptyList()
            }

            val moshi: Moshi = Moshi.Builder().build()
            val adapter: JsonAdapter<List<RevSymbol>> = moshi.adapter()

            adapter.fromJson(json).orEmpty()
        }
    }
}

@JsonClass(generateAdapter = true)
data class RevSymbolNames(val french: String, val english: String)

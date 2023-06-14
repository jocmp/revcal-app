package com.jocmp.revcal.client

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Symbol(
    val id: String,
    val name: String,
    val frenchName: String,
    val imageURL: String?,
    val attribution: SymbolAttribution
)

@JsonClass(generateAdapter = true)
data class SymbolAttribution(
    val creatorName: String?,
    val sourceUrl: String?,
    val license: String?
)

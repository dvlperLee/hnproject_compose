package com.yangholee.hnproject_compose.data.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HistoryList (
    @Json
    val consignorId: String?,
    @Json
    val blNumber: String?,
    @Json
    val containCount: Int?,
    @Json
    val inCount: Int?,
    @Json
    val outCount: Int?
)
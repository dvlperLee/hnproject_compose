package com.yangholee.hnproject_compose.data.api

import com.yangholee.hnproject_compose.data.api.model.HistoryList
import retrofit2.http.GET

interface HistoryApi {
    @GET(ApiConstants.END_POINTS)
    suspend fun getHistoryList() : List<HistoryList>
}
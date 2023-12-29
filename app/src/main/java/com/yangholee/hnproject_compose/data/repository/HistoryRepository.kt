package com.yangholee.hnproject_compose.data.repository

import com.yangholee.hnproject_compose.data.api.HistoryApi
import com.yangholee.hnproject_compose.data.api.model.HistoryList
import javax.inject.Inject

class  HistoryRepository @Inject constructor(
    private val historyApi: HistoryApi
){

    suspend fun getHistoryLists(): List<HistoryList> {
        return historyApi.getHistoryList()
    }
}
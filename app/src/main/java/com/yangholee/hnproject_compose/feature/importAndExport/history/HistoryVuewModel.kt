package com.yangholee.hnproject_compose.feature.importAndExport.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yangholee.hnproject_compose.data.api.model.HistoryList
import com.yangholee.hnproject_compose.data.repository.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryVuewModel @Inject constructor(
    private val historyRepository: HistoryRepository
):ViewModel(){
    private val _state = MutableStateFlow(emptyList<HistoryList>())
    val state: StateFlow<List<HistoryList>>
        get() = _state

    /**
     * Get the values from the API
     */

    init {
        viewModelScope.launch {
            val historyLists = historyRepository.getHistoryLists()
            _state.value = historyLists
        }
    }
}
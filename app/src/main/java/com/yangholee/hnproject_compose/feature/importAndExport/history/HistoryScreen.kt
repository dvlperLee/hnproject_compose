package com.yangholee.hnproject_compose.feature.importAndExport.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.yangholee.hnproject_compose.data.api.model.HistoryList

@Composable
fun HistoryScreen(
    navController: NavHostController,
    modifier : Modifier = Modifier,
    historyViewModel: HistoryVuewModel = hiltViewModel(),
){
    //val historyViewModel = viewModel(modelClass = HistoryVuewModel::class.java)
    val state by historyViewModel.state.collectAsState()
    Column(
    ) {
        state.forEach{
            his -> Text(text = "${his.consignorId}")
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
 //   LazyColumn {
//        items(state){history: HistoryList ->
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Start,
//
//
//
//                )
//
//            {
//                Text(text = "${history.consignorId}")
//
//            }
//        }
//}
}
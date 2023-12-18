package com.yangholee.hnproject_compose.main

import android.graphics.Paint.Style
import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.yangholee.hnproject_compose.navigation.NavRoutes
import com.yangholee.hnproject_compose.navigation.hnNavHost
import com.yangholee.hnproject_compose.R.drawable
import com.yangholee.hnproject_compose.main.JobItem as JobItem

@Composable
fun MainScreen(
    navController: NavHostController,
    modifier : Modifier = Modifier
) {
    val menuList = arrayOf("반입", "반출", "입반출관리","입반출 내역", "로그아웃")
    Column(
        modifier = modifier
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
//        itemsIndexed(menuList){
//            index, item ->
//                Card(
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Button(
//                        onClick = { /*TODO*/ },
//                        modifier.fillMaxWidth()
//                    ) {
//                        Text(text = "$item")
//                    }
//
//                }
//        }
        JobItem(name = "반입", resId = drawable.ic_launcher_foreground , description = "설명", onClick = { /*TODO*/ })
        JobItem(name = "반출", resId = drawable.ic_launcher_foreground , description = "설명", onClick = { /*TODO*/ })
        JobItem(name = "입반출 내역", resId = drawable.ic_launcher_foreground , description = "설명", onClick = { /*TODO*/ })
        JobItem(name = "로그아웃", resId = drawable.ic_launcher_foreground , description = "설명", onClick = { /*TODO*/ })
    }

//    Column {
//        Button(onClick = { /*TODO*/ }) {
//            Text(text = "반입")
//        }
//        Button(onClick = { /*TODO*/ }) {
//            Text(text = "반출")
//        }
//        Button(onClick = { /*TODO*/ }) {
//            Text(text = "입반출 내역")
//        }
//        Button(onClick = { /*TODO*/ }) {
//            Text(text = "로그아웃")
//        }
//    }
}
package com.yangholee.hnproject_compose.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.yangholee.hnproject_compose.R
import com.yangholee.hnproject_compose.navigation.NavRoutes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    val userId = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }

    val focusRequester = remember {
        FocusRequester()
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.hn_logo),
            contentDescription = ""
        )
//        Text(
//            style = MaterialTheme.typography.headlineMedium,
//            text = "Login"
//        )
        Surface(color = MaterialTheme.colorScheme.background) {
            OutlinedTextField(
                value = userId.value,
                onValueChange = {
                    userId.value = it
                                },
                label = { Text(text = "ID") },
                enabled = true,
                placeholder = { Text(text = "아이디를 입력해주세요.") },
                leadingIcon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "") },
                singleLine = true,
                keyboardOptions =  KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {focusRequester.requestFocus()})
            )
        }
        Surface(color = MaterialTheme.colorScheme.background) {
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text(text = "PASSWORD") },
                enabled = true,
                placeholder = { Text(text = "비밀번호를 입력해주세요.") },
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "")},
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                modifier = Modifier.focusRequester(focusRequester)
            )
        }
        Button(
            onClick = { navController.navigate(NavRoutes.main.route) }
            , content = { Text(text = "Login")}
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    title: String,
    textState: String,
    onTextChange: (String) -> Unit,){
    OutlinedTextField(
        value = textState,
        onValueChange ={onTextChange(it)},
        singleLine = true,
        label = { Text(title)},
        modifier = Modifier.padding(10.dp),
        textStyle = TextStyle(fontWeight = FontWeight.Bold, fontSize = 30.sp)
    )
}
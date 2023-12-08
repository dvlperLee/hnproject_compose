package com.yangholee.hnproject_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.DefaultMarqueeDelayMillis
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yangholee.hnproject_compose.ui.theme.Hnproject_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Hnproject_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()
                }
            }
        }
    }
}

@Composable
fun Screen(){
    LoginScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(){
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
                leadingIcon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")},
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
            onClick = { /*TODO*/ }
            , content = { Text(text = "Login")}
        )

    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Screen()
}
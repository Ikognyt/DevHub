package br.com.ylotec.devhub.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchUserScreen(
    onEnterClick: (user: String) -> Unit = {}
) {
    var user by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color(0xFF232324))
        ,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "DevHub",
            fontSize = 64.sp,
            modifier = Modifier.paddingFromBaseline(bottom = 64.sp),
            fontWeight = FontWeight(weight = 600),
            fontStyle = FontStyle.Italic,
            color = Color.White
        )
        OutlinedTextField(
            value = user,
            onValueChange = {
                user = it
            },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            label = {
                Text(text = "Usuário")
            }
        )
        Button(
            onClick = { onEnterClick(user) },
            Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
                .fillMaxWidth()
        ) {
            Text(text = "Entrar")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SearchUserScreenPreview() {
    SearchUserScreen()
}
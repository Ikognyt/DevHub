package br.com.ylotec.devhub.views

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import br.com.ylotec.devhub.R
import br.com.ylotec.devhub.ui.theme.DevHubTheme
import br.com.ylotec.devhub.webclient.FlowApiGithub
import br.com.ylotec.devhub.webclient.FlowApiGithub.Companion.TAG
import br.com.ylotec.devhub.webclient.RetrofitService
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch{
            RetrofitService.gitHubService.getUserData("ikognyt").let {
                Log.i(TAG, "onCreate Trace getUserData: $it")
            }

        }
        setContent {
            DevHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserCard("ikognyt")
                }
            }
        }
    }

    @Composable
    fun UserCard(
        user: String,
        flowApiGithub: FlowApiGithub = FlowApiGithub()
    ) {
        val findUser by flowApiGithub.findProfileBy(user).collectAsState(initial = null)

        Log.i(TAG, "UserCard Trace userObject: $findUser")
        findUser?.let { userProfile ->
            Column(
                modifier = Modifier
                    .absoluteOffset(0.dp, (-15).dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xFF7D34EB), RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .absoluteOffset(0.dp, 55.dp)
                ) {

                    Log.i(TAG, "UserCard Trace avatar_url: ${userProfile.avatar_url}")
                    AsyncImage(
                        model = userProfile.avatar_url.toString(),
                        contentDescription = "Foto do usuário",
                        Modifier
                            .clip(CircleShape)
                            .size(130.dp)
                            .align(Center)
                    )
                    Icon(
                        painter = painterResource(
                            id = R.drawable.ic_baseline_beenhere_24
                        ),
                        contentDescription = "Been Here Check",
                        Modifier
                            .absoluteOffset(40.dp, 55.dp)
                            .clip(CircleShape)
                            .size(30.dp)
                            .align(Center),
                        Color.Red
                    )
                }
                Box(
                    modifier = Modifier
                        .align(CenterHorizontally)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Center)
                    ) {

                        Text(
                            userProfile.name,
                            Modifier.absoluteOffset(100.dp, 60.dp),
                            Color.Black,
                            fontSize = 30.sp
                        )
                        Text(
                            userProfile.blog,
                            Modifier.absoluteOffset(150.dp, 90.dp),
                            Color.Black,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            userProfile.bio,
                            Modifier.absoluteOffset(40.dp, 30.dp),
                            Color.Black,
                            fontSize = 20.sp
                        )
                    }

                }
            }

        }
    }
}

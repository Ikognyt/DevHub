package br.com.ylotec.devhub.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ylotec.devhub.R
import br.com.ylotec.devhub.model.User
import br.com.ylotec.devhub.webclient.FlowApiGithub
import coil.compose.AsyncImage


class ComposeViewUser {

    companion object {
        @Composable
        fun ProfilePreview(user: String,
                           flowApiGithub: FlowApiGithub = FlowApiGithub()
        ) {

            val findUser by flowApiGithub.findProfileBy(user).collectAsState(initial = null)

            Log.i(FlowApiGithub.TAG, "UserCard Trace userObject: $findUser")
            findUser?.let { userProfile ->
                Profile(userProfile)
            }
        }

        @Composable
        private fun Profile(userProfile: User) {
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

                    Log.i(
                        FlowApiGithub.TAG,
                        "UserCard Trace avatar_url: ${userProfile.avatar_url}"
                    )
                    AsyncImage(
                        model = userProfile.avatar_url.toString(),
                        contentDescription = "Foto do usuário",
                        Modifier
                            .clip(CircleShape)
                            .size(130.dp)
                            .align(Alignment.Center)
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
                            .align(Alignment.Center),
                        Color.Red
                    )
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
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
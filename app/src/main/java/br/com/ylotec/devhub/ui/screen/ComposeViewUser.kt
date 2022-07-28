package br.com.ylotec.devhub.ui.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import br.com.ylotec.devhub.R
import br.com.ylotec.devhub.model.User
import br.com.ylotec.devhub.model.UserRepos
import br.com.ylotec.devhub.webclient.FlowGetUser
import br.com.ylotec.devhub.webclient.FlowGetUser.Companion.TAG
import coil.compose.AsyncImage


class ComposeViewUser {


    @Composable
    fun ProfilePreview(
        user: String,
       flowApiGithub: FlowGetUser = FlowGetUser(),
    ) {
        LaunchedEffect(null){
            flowApiGithub.findProfileBy(user)
        }
        Profile(flowApiGithub.userData)
    }

    @Composable
    private fun Profile(userProfile: User) {
        LazyColumn{
            item {
                ProfileMainData(userProfile)
            }
            if(userProfile.repositories.isNotEmpty()){
                item {
                    Column(modifier = Modifier
                        .absoluteOffset(0.dp, 50.dp)) {
                        Text(
                            "Repositories: ",
                            Modifier
                                .absoluteOffset(5.dp, 0.dp)
                                .padding(bottom = 15.dp),
                            Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight(weight = 700),
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
                items(userProfile.repositories){repo ->
                    Log.i(TAG, "Profile Trace repo: $repo")
                    Repos(repo)
                }
            }

        }
    }

    @Composable
    private fun ProfileMainData(userProfile: User) {
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
                    FlowGetUser.TAG,
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
                    .align(CenterHorizontally)
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

    @Composable
    fun Repos(repo: UserRepos){
        ConstraintLayout() {
            Column(modifier = Modifier
                .absoluteOffset(20.dp, 50.dp)) {
                Column(
                    modifier = Modifier
                        .absoluteOffset(0.dp, (-5).dp)
                        .align(CenterHorizontally)
                        .zIndex(3f)
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color(0xFF232324), RoundedCornerShape(10.dp))
                            .width(350.dp)
                            .height(40.dp)
                            .align(CenterHorizontally)
                            .absoluteOffset(5.dp, (-20).dp)
                            .zIndex(2f),
                            propagateMinConstraints = true
                    ) {
                        if (!repo.name.isNullOrBlank())
                            Text(
                                repo.name,
                                Modifier.absoluteOffset(10.dp, 27.dp),
                                Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight(weight = 700),
                                textAlign = TextAlign.Start
                            )

                    }
                }
                Column(
                    modifier = Modifier
                        .absoluteOffset(0.dp, (-25).dp)
                        .align(CenterHorizontally)
                        .padding(bottom = 20.dp)
                        .zIndex(2f)
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color(0xFFdbdbdb), RoundedCornerShape(10.dp))
                            .width(350.dp)
                            .align(CenterHorizontally)
                            .shadow(10.dp, RectangleShape, false, DefaultShadowColor, Color.Transparent)
                            .absoluteOffset(10.dp, 0.dp)
                            .widthIn(350.dp)
                            .heightIn(50.dp)
                            .padding(10.dp),
                        propagateMinConstraints = true
                    ) {
                        if (!repo.description.isNullOrBlank())
                            Text(
                                repo.description + "\n",
                                Modifier.absoluteOffset((-10).dp, 15.dp).padding(10.dp),
                                Color.Black,
                                fontSize = 25.sp,
                                fontWeight = FontWeight(weight = 500)
                            )
                    }
                }
            }
        }
    }
}
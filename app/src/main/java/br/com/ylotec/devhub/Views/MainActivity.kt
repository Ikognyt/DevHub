package br.com.ylotec.devhub.Views

import android.os.Bundle
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
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ylotec.devhub.R
import br.com.ylotec.devhub.ui.theme.DevHubTheme
import coil.compose.AsyncImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserCard()
                }
            }
        }
    }



    @Composable
    fun UserCard() {
        Column(modifier = Modifier
            .absoluteOffset(0.dp, (-10).dp)
        ) {
            Box(modifier = Modifier
                .background(Color(0xFF7D34EB), RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .absoluteOffset(0.dp, 55.dp)
            ) {
                AsyncImage(
                    model = "https://avatars.githubusercontent.com/u/32139927?v=4",
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
            Box(modifier = Modifier
                .align(CenterHorizontally)
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .align(Center)
                ) {

                    Text("Filipe Andrade", Modifier.absoluteOffset(100.dp, 60.dp), Color.Black, fontSize = 30.sp)
                    Text("ikognyt", Modifier.absoluteOffset(150.dp, 60.dp), Color.Black, fontSize = 25.sp, fontWeight = FontWeight.Bold)
                    Text("Android Developer Jr at Venturus ", Modifier.absoluteOffset(45.dp, 75.dp), Color.Black, fontSize = 20.sp)
                }

            }
        }

    }


}
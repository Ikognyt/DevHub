package br.com.ylotec.devhub

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.colorspace.Rgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.ylotec.devhub.ui.theme.DevHubTheme
import kotlin.math.round

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
                Image(
                    painter = painterResource(id = R.drawable.filipe_fb_rzd),
                    contentDescription = "Foto do usuário",
                    Modifier
                        .clip(CircleShape)
                        .size(130.dp)
                        .align(Center)
                )
            }
            Box(modifier = Modifier
                .align(CenterHorizontally)
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_baseline_beenhere_24),
                    contentDescription = "Been Here Check",
                    Modifier
                        .absoluteOffset(40.dp, 0.dp)
                        .clip(CircleShape)
                        .size(30.dp)
                        .align(Center),
                    Color.Red
                )
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

    @Composable
    fun BackgroundUser(){
        Row(horizontalArrangement = Arrangement.Center) {
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color.Black)

        }

    }


}
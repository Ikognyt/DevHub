package br.com.ylotec.devhub.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import br.com.ylotec.devhub.ui.screen.SearchUserScreen
import br.com.ylotec.devhub.ui.screen.ComposeViewUser
import br.com.ylotec.devhub.ui.theme.DevHubTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHubTheme {
                var screenState: AppScreens by remember {
                    mutableStateOf(AppScreens.Authentication)
                }
                var user by remember {
                    mutableStateOf("")
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (screenState) {
                        AppScreens.Authentication -> {
                            SearchUserScreen(
                                onEnterClick = {
                                    if (it.isNotBlank()) {
                                        user = it
                                        screenState = AppScreens.Profile
                                    }
                                }
                            )
                        }
                        AppScreens.Profile -> {
                            ComposeViewUser().ProfilePreview(user)
                        }
                    }

                }
            }
        }

    }
}


sealed class AppScreens {
    object Authentication : AppScreens()
    object Profile : AppScreens()
    //ComposeViewUser().ProfilePreview("ikognyt")
}

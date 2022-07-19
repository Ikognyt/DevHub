package br.com.ylotec.devhub.views

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import br.com.ylotec.devhub.ui.screen.ComposeViewUser.Companion.ProfilePreview
import br.com.ylotec.devhub.ui.theme.DevHubTheme
import br.com.ylotec.devhub.webclient.FlowApiGithub.Companion.TAG
import br.com.ylotec.devhub.webclient.RetrofitService
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
                    ProfilePreview("ikognyt")
                }
            }
        }
    }
}

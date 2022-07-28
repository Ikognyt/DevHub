package br.com.ylotec.devhub.webclient

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import br.com.ylotec.devhub.model.User
import br.com.ylotec.devhub.utils.URLs
import retrofit2.Retrofit


class FlowGetUser(
    private val builder: Retrofit.Builder = RetrofitService.builder,
    private val service: ISyncUserGitHub = builder
        .baseUrl(URLs.GITHUB_USER_API)
        .build()
        .create(ISyncUserGitHub::class.java)
) {

    companion object {
       const val TAG  = "TaskApiGithub"
   }

    var userData by mutableStateOf(User())
        private set

    suspend fun findProfileBy(user: String) {
        try {
            val profile = service.getUserData(user)

            val repositories = service.getRepos(user)

            Log.i(TAG, "findProfileBy Trace: $repositories")

            userData = profile.copy(repositories = repositories)


        }catch (e: Exception){
            Log.e(TAG, "findProfileBy: ", e)
        }
    }


}
package br.com.ylotec.devhub.webclient

import android.util.Log
import kotlinx.coroutines.flow.flow


class FlowApiGithub(
    private val service: ISyncUserGitHub = RetrofitService.gitHubService
) {

    companion object {
       const val TAG  = "TaskApiGithub"
   }

    fun findProfileBy(user: String) = flow {
        Log.i(TAG, "findProfileBy Trace user: $user")
        try {
            emit(service.getUserData(user))

        } catch (e: Exception) {
            Log.e(TAG, "findProfileBy: ", e)
        }
    }


}
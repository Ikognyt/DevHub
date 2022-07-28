package br.com.ylotec.devhub.webclient

import br.com.ylotec.devhub.model.User
import br.com.ylotec.devhub.model.UserRepos
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming

interface ISyncUserGitHub {

    @Streaming
    @GET("{id}")
    suspend fun getUserData(@Path("id") id : String) : User

    @Streaming
    @GET("{id}/repos")
    suspend fun getRepos(@Path("id") id : String) : List<UserRepos>
}
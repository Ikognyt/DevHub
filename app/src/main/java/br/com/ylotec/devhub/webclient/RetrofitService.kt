package br.com.ylotec.devhub.webclient

import br.com.ylotec.devhub.utils.URLs
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitService {

    companion object{
        private val client : OkHttpClient = OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).writeTimeout(5, TimeUnit.SECONDS).build()
        private val builder : Retrofit.Builder = Retrofit.Builder().client(client).baseUrl(URLs.GITHUB_USER_API).addConverterFactory(GsonConverterFactory.create())
        private val retrofit : Retrofit = builder.build()

        val gitHubService: ISyncUserGitHub get() = retrofit.create(ISyncUserGitHub::class.java)
    }


}
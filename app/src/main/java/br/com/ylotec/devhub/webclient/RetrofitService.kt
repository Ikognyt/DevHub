package br.com.ylotec.devhub.webclient

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitService {

    companion object{
        private val client : OkHttpClient =
            OkHttpClient
                .Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build()

        val builder : Retrofit.Builder =
            Retrofit
                .Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
    }
}
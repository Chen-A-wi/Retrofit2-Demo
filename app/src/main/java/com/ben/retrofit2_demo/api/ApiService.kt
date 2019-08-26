package com.ben.retrofit2_demo.api

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Config {
    const val URL = "https://jsonplaceholder.typicode.com"
}

class ApiService {

    private var logging = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Log.i("interceptor msg", message)
        }
    })

    fun createRetrofit(url: String): Retrofit {
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient().newBuilder().addInterceptor(logging).build()
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit
    }
}

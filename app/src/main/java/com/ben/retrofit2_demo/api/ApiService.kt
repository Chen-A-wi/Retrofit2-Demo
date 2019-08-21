package com.ben.retrofit2_demo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
  val githubUrl = "http://api.github.com/"

  fun getGithubSearch() {
    createRetrofit<GithubService>(githubUrl)
  }

  inline fun <reified T> createRetrofit(url: String): T {
    val retrofit = Retrofit.Builder()
      .baseUrl(url)
      .addConverterFactory(GsonConverterFactory.create())
      .build()

    return retrofit.create(T::class.java)
  }
}

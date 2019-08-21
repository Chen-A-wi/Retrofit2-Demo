package com.ben.retrofit2_demo.api

import com.ben.retrofit2_demo.data.RepoSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService  {
    @GET("search/repositories")
    fun searchRepos(@Query("q") query:String): Call<RepoSearchResponse>
}
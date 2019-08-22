package com.ben.retrofit2_demo.api

import com.ben.retrofit2_demo.data.PostsResp
import retrofit2.Call
import retrofit2.http.GET

interface JsonplaceholderService {
    @GET
    fun Posts(): Call<List<PostsResp>>
}
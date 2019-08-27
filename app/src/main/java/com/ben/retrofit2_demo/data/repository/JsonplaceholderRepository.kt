package com.ben.retrofit2_demo.data.repository

import com.ben.retrofit2_demo.api.JsonPlaceholderService
import com.ben.retrofit2_demo.data.PostsResp
import retrofit2.Call

class JsonPlaceholderRepository(private val service: JsonPlaceholderService) {
    fun posts(): Call<List<PostsResp>> {
        return service.posts()
    }
}

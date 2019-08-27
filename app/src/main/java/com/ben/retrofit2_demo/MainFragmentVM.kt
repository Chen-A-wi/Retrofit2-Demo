package com.ben.retrofit2_demo

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ben.retrofit2_demo.data.PostsResp
import com.ben.retrofit2_demo.data.repository.JsonPlaceholderRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragmentVM(private val repo: JsonPlaceholderRepository) : ViewModel() {
    val respBody = MutableLiveData<String>()

    fun onClick(v: View) {
        when (v.id) {
            R.id.button -> {
                repo.posts().enqueue(object : Callback<List<PostsResp>> {
                    override fun onResponse(
                        call: Call<List<PostsResp>>,
                        response: Response<List<PostsResp>>
                    ) {
                        val sb = StringBuffer()

                        response.body()?.forEach { postsResp ->
                            sb.append(postsResp.body)
                            sb.append("\n")
                            sb.append("---------------------\n")
                        }

                        respBody.postValue(sb.toString())
                    }

                    override fun onFailure(call: Call<List<PostsResp>>, t: Throwable) {

                    }
                })
            }
        }
    }

}

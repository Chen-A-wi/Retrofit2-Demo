package com.ben.retrofit2_demo.data

import com.google.gson.annotations.SerializedName

data class RepoSearchResponse(
  @SerializedName("total_count")
  var total: Int

//  var items: List<Repo>
)

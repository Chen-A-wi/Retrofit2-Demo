package com.ben.retrofit2_demo.utils

import com.google.gson.Gson

object GsonUtil {
    private val g = Gson()

    fun toJson(obj: Any): String {
        return g.toJson(obj)
    }
}

package com.ben.retrofit2_demo.di

import com.ben.retrofit2_demo.MainFragmentVM
import com.ben.retrofit2_demo.api.Config
import com.ben.retrofit2_demo.api.JsonPlaceholderService
import com.ben.retrofit2_demo.data.repository.JsonPlaceholderRepository
import com.ben.retrofit2_demo.utils.LoggerInterceptor
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val mainVmModule = module {
  viewModel { MainFragmentVM(get()) }
}

val apiModule = module {
  single { createOkHttpClient() }
  single { createRetrofit<JsonPlaceholderService>(get(), Config.URL) }
}

val repositoryModule = module {
  single { JsonPlaceholderRepository(get()) }
}

val diModules = listOf(
  mainVmModule,
  apiModule,
  repositoryModule
)

fun createOkHttpClient(): OkHttpClient {
  return OkHttpClient.Builder()
    .addNetworkInterceptor(LoggerInterceptor())
    .connectTimeout(60L, TimeUnit.SECONDS)
    .readTimeout(60L, TimeUnit.SECONDS)
    .connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
    .build()
}

inline fun <reified T> createRetrofit(okHttpClient: OkHttpClient, serverUrl: String): T {

  val retrofit = Retrofit.Builder()
    .baseUrl(serverUrl)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

  return retrofit.create(T::class.java)
}

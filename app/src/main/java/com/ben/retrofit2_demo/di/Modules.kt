package com.ben.retrofit2_demo.di

import com.ben.retrofit2_demo.MainFragmentVM
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainVmModule = module {
  viewModel { MainFragmentVM() }
}

val diModules = listOf(
  mainVmModule
)

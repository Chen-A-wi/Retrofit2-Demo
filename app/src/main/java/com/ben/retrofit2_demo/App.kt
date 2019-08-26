package com.ben.retrofit2_demo

import android.app.Application
import com.ben.retrofit2_demo.di.diModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(diModules)
        }
    }
}

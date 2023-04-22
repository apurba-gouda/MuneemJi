package com.appworkd.muneemji.root

import android.app.Application
import com.appworkd.muneemji.root.di.DaggerApplicationComponent

class MuneemJiApp : Application() {
    val appComponent by lazy {
        DaggerApplicationComponent.builder().build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}
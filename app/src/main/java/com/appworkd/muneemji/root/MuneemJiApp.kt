package com.appworkd.muneemji.root

import android.app.Application
import com.appworkd.muneemji.root.di.ApplicationComponent
import com.appworkd.muneemji.root.di.ApplicationModule
import com.appworkd.muneemji.root.di.DaggerApplicationComponent
import com.appworkd.network.di.NetworkModule

class MuneemJiApp : Application() {
      val appComponent: ApplicationComponent by lazy {
          DaggerApplicationComponent.builder()
              .appModule(ApplicationModule(this))
              .networkModule(NetworkModule(this.applicationContext))
              .build()
      }

    override fun onCreate() {
        super.onCreate()
    }
}
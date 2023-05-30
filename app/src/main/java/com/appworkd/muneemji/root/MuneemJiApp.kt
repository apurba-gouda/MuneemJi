package com.appworkd.muneemji.root

import android.app.Application
import com.appworkd.muneemji.root.di.ApplicationComponent
import com.appworkd.muneemji.root.di.ApplicationModule
import com.appworkd.muneemji.root.di.DaggerApplicationComponent
import com.appworkd.network.di.NetworkComponent
import com.appworkd.network.di.DaggerNetworkComponent
import com.appworkd.network.di.NetworkModule

class MuneemJiApp : Application() {

    private val networkComponent: NetworkComponent by lazy {
        DaggerNetworkComponent.builder()
            .networkModule(NetworkModule(this.applicationContext))
            .build()
    }

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .networkComponent(networkComponent)
            .appModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}
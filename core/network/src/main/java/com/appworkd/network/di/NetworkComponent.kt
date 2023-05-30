package com.appworkd.network.di

import com.appworkd.network.MnjNetworkDataSource
import dagger.Component

@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    @Component.Builder
    interface Builder {
        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): NetworkComponent
    }

    fun mnjNetworkDataSource(): MnjNetworkDataSource
}

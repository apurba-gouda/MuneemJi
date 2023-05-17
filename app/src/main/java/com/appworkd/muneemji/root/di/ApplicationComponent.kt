package com.appworkd.muneemji.root.di

import android.content.Context
import com.appworkd.data.repo.post.PostRepository
import com.appworkd.muneemji.root.loggedout.main.view.MainActivity
import com.appworkd.network.di.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class]) //FixMe Add FeatureComponent and provide dependencies from that component
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun appModule(appModule: ApplicationModule): Builder
        fun networkModule(networkModule: NetworkModule): Builder
        fun build(): ApplicationComponent
    }

    fun injectActivity(activity: MainActivity)

    fun provideAppContext(): Context
    fun providePostRepo() : PostRepository
}
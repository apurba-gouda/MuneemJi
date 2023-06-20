package com.appworkd.muneemji.root.di

import android.content.Context
import com.appworkd.data.repo.post.PostRepository
import com.appworkd.muneemji.root.loggedout.main.view.MainActivity
import com.appworkd.network.di.NetworkComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [NetworkComponent::class], modules = [ApplicationModule::class]) //FixMe Add FeatureComponent and provide dependencies from that component
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun networkComponent(component: NetworkComponent): Builder
        fun appModule(appModule: ApplicationModule): Builder
        fun build(): ApplicationComponent
    }

    fun injectActivity(activity: MainActivity)

    fun provideAppContext(): Context
    fun providePostRepo() : PostRepository
}
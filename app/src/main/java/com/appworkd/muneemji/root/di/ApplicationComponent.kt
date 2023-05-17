package com.appworkd.muneemji.root.di

import android.content.Context
import com.app.di.app.FeatureComponent
import com.appworkd.muneemji.root.loggedout.main.view.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [FeatureComponent::class], modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun injectActivity(activity: MainActivity)

    fun provideAppContext(): Context
}
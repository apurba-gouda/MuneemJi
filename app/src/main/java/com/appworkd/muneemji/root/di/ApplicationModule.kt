package com.appworkd.muneemji.root.di

import android.content.Context
import com.appworkd.data.repo.post.PostRepository
import com.appworkd.data.repo.post.PostRepositoryImpl
import com.appworkd.muneemji.root.MuneemJiApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * This class will be responsible for creating all the dependencies used in the system at application level.
 */

@Module
class ApplicationModule(private val app: MuneemJiApp) {

    @Singleton
    @Provides
    fun provideContext() : Context = app.applicationContext

    @Singleton
    @Provides
    fun provideApplication() : MuneemJiApp = app

    @Provides
     fun providePostRepo(postRepositoryImpl: PostRepositoryImpl): PostRepository = postRepositoryImpl
}
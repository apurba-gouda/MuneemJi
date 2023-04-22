package com.appworkd.muneemji.root.di

import android.content.Context
import com.appworkd.muneemji.root.MuneemJiApp
import dagger.Module
import dagger.Provides

/**
 * This class will be responsible for creating all the dependencies used in the system at application level.
 */

@Module
abstract class ApplicationModule {
    companion object {

        @Provides
        fun provideContext() : Context = MuneemJiApp().applicationContext
    }
}
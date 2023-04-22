package com.appworkd.muneemji.root.loggedout.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.appworkd.muneemji.databinding.ActivityMainBinding
import com.appworkd.muneemji.root.MuneemJiApp
import com.appworkd.muneemji.root.loggedout.main.navigation.MainNavigator
import com.appworkd.muneemji.root.loggedout.main.navigation.MainNavigatorImpl

class MainActivity : AppCompatActivity() {
    private val appComponent by lazy { MuneemJiApp().appComponent }
    private val navigator: MainNavigator by lazy { MainNavigatorImpl(this) }

    private val viewBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.injectActivity(this)
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(viewBinding.root)
    }
}

/**
 * 1. Creating own wrappers for Coroutines.
 * 2. Creating View in a separate module or start Jetpack Compose
 * 3. Creating module for network request
 * 4. Creating exception handlers
 * 5. Creating analytics pipe line
 * 6. Setup Github Actions
 * 7.
 */
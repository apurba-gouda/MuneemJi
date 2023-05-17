package com.appworkd.muneemji.root.loggedout.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.appworkd.data.repo.post.PostRepository
import com.appworkd.muneemji.databinding.ActivityMainBinding
import com.appworkd.muneemji.root.MuneemJiApp
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val viewBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    @Inject
    lateinit var postRepository: PostRepository

    override fun onCreate(savedInstanceState: Bundle?) {

        val myApp = application as MuneemJiApp
        myApp.appComponent.injectActivity(this)

        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(viewBinding.root)

        lifecycleScope.launch {
            try {
                launch { postRepository.getPosts() }
                getPosts()
            } catch (e: Exception) {
                println("Posts: inside exception : ${e.message} ")
            }
        }
    }

    private suspend fun getPosts() {
        postRepository.posts
            .collect {
                println("Posts: inside collect ")
                it.forEach { println("Posts: inside collect it with value: $it ") }
            }
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
package com.appworkd.network.di

import android.content.Context
import com.appworkd.network.MnjNetworkDataSource
import com.appworkd.network.MnjNetworkDataSourceImpl
import com.appworkd.network.feature.post.PostService
import com.appworkd.network.feature.post.data.HttpPostService
import com.appworkd.network.ktor.KtorClient
import dagger.Module
import dagger.Provides
import io.ktor.client.*

@Module
class NetworkModule(
    private val context: Context,
) {
    @Provides
    fun provideClient(): HttpClient = KtorClient(context).client

    @Provides
    fun providePostService(postService: HttpPostService): PostService = postService

    @Provides
    fun providesMnjNetworkDataSource(mnjNetworkDataSourceImpl: MnjNetworkDataSourceImpl): MnjNetworkDataSource =
        mnjNetworkDataSourceImpl
}

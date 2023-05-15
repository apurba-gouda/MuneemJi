package com.appworkd.network

import com.appworkd.network.feature.post.model.Post

interface MnjNetworkDataSource {
    suspend fun getPosts(): List<Post>
}

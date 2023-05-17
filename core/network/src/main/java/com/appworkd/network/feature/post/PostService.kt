package com.appworkd.network.feature.post

import com.appworkd.network.feature.post.model.Post

interface PostService {
    suspend fun fetchPost() : List<Post>
}
package com.appworkd.data.repo.post

import com.appworkd.network.feature.post.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    val posts: Flow<List<Post>>
    suspend fun getPosts()
}

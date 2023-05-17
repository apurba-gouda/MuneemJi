package com.appworkd.network

import com.appworkd.network.feature.post.PostService
import com.appworkd.network.feature.post.model.Post
import javax.inject.Inject

class MnjNetworkDataSourceImpl
@Inject
constructor(
    private val postService: PostService,
    ) : MnjNetworkDataSource {

    override suspend fun getPosts(): List<Post> = postService.fetchPost()

}

package com.appworkd.data.repo.post

import com.appworkd.network.MnjNetworkDataSource
import com.appworkd.network.feature.post.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostRepositoryImpl
@Inject
constructor(
    private val dataSource: MnjNetworkDataSource,
) : PostRepository {

    private val mutableData: MutableStateFlow<List<Post>> = MutableStateFlow(emptyList())
    override val posts: Flow<List<Post>>
        get() = mutableData

    override suspend fun getPosts() {
        println("Posts: inside PostRepositoryImpl ")
        mutableData.value = dataSource.getPosts()
    }

}
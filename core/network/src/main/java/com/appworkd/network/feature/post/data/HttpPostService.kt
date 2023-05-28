@file:OptIn(ExperimentalSerializationApi::class)

package com.appworkd.network.feature.post.data

import com.appworkd.network.feature.post.PostService
import com.appworkd.network.feature.post.model.Post
import com.appworkd.network.feature.post.model.PostResponse
import com.appworkd.network.ktor.httpCall
import com.appworkd.network.model.exceptions.ApiException
import com.appworkd.network.serde.JsonProvider
import com.appworkd.network.serde.httpDeserialize

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.path
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.builtins.ListSerializer
import javax.inject.Inject

class HttpPostService
@Inject
constructor(
    private val httpClient: HttpClient,
) : PostService {

    override suspend fun fetchPost(): List<Post> = httpCall {
        httpClient.get {
            url { path("posts") }
        }.httpDeserialize(
            JsonProvider().invoke(emptyList()),
            ListSerializer(Post.serializer()),
            ApiException.serializer(),
        )
    }
}
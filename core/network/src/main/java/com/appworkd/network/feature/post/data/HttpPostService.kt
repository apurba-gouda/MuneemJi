package com.appworkd.network.feature.post.data

import com.appworkd.network.feature.post.PostService
import com.appworkd.network.feature.post.model.Post
import com.appworkd.network.ktor.httpCall
import com.appworkd.network.model.exceptions.ApiException
import com.appworkd.network.serde.JsonProvider.json
import com.appworkd.network.serde.httpDeserialize
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.path
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
            json,
            ListSerializer(Post.serializer()),
            ApiException.serializer(),
        )
    }
}
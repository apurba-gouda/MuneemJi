package com.appworkd.network.feature.post.data

import com.appworkd.network.feature.post.PostService
import com.appworkd.network.feature.post.model.Post

import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

import javax.inject.Inject

class HttpPostService
@Inject
constructor(
    private val httpClient: HttpClient,
) : PostService {

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun fetchPost(): List<Post> {
        return try {
            val json =  httpClient.get<String> {
                url { path("posts") }
            }
            Json.decodeFromString(json)
        } catch (e: Exception) {
            e.message
            throw Exception("Parsing Exception")
        }
    }
}
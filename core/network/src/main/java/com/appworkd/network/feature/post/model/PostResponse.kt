package com.appworkd.network.feature.post.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class PostResponse(
    val posts : List<Post>,
)



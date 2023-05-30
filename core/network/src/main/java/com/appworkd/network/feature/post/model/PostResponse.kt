package com.appworkd.network.feature.post.model

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val posts : List<Post>,
)



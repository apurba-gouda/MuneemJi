package com.appworkd.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EmptyResponse(
    @SerialName("empty_response")
    val response :Unit = Unit
)
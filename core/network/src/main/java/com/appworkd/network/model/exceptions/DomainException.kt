package com.appworkd.network.model.exceptions

data class DomainException(
    override val url :String,
    override val cause: Throwable,
): NetworkException(url = url, cause = cause)

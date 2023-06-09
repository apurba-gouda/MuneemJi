package com.appworkd.network.model.exceptions

data class StrategyFailureException(
    override val url: String,
    override val cause: Throwable
) : NetworkException(url = url, cause = cause)

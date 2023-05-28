package com.appworkd.network.model.exceptions

data class UnknownHttpException(
    override val cause: Throwable,
) : Exception(cause)

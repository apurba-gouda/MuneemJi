package com.appworkd.network.ktor

import com.appworkd.network.model.exceptions.DomainException
import com.appworkd.network.model.exceptions.NetworkException
import com.appworkd.network.model.exceptions.ParsingException
import com.appworkd.network.model.exceptions.ServerException
import com.appworkd.network.model.exceptions.StrategyFailureException
import com.appworkd.network.model.exceptions.UnknownException
import com.appworkd.network.model.exceptions.UnknownHttpException

suspend fun <Success> httpCall(
    job: suspend () -> Success,
): Success =
    try {
        job.invoke()
    } catch (e: Exception) {
        when (e) {
            is NetworkException -> handleNetworkException(e)
            else -> throw UnknownHttpException(e)
        }
    }

fun handleNetworkException(e: NetworkException): Nothing =
    when (e) {
        is DomainException -> {
            println("API failure with url: ${e.url}")
            throw e.cause
        }
        is ParsingException -> {
            println("API failure $e with url: ${e.url} with code: ${e.statusCode}")
            throw e
        }
        is ServerException -> {
            println("API failure $e with url: ${e.url} with code: ${e.statusCode}")
            throw e
        }
        is StrategyFailureException -> {
            println("API failure $e with url: ${e.url} with code: ${e.cause}")
            throw e
        }
        is UnknownException -> {
            println("API failure $e with url: ${e.url} with code: ${e.msg}")
            throw e
        }
    }


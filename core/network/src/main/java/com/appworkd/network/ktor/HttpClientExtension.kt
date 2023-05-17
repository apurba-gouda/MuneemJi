package com.appworkd.network.ktor

import com.appworkd.network.urlprovider.UrlProvider
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.*
import io.ktor.http.*

fun <T: HttpClientEngineConfig> HttpClientConfig<T>.initDefaultConfigs(
    urlProvider: UrlProvider,
)
{
    defaultRequest {
        url {
          protocol = URLProtocol.HTTPS
          host = urlProvider()
        }
    }

    //HERE ADD HEADERS AS WELL
}

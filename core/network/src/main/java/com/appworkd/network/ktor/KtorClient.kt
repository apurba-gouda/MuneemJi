package com.appworkd.network.ktor

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import javax.inject.Inject

class KtorClient
@Inject
constructor(
private val context: Context,
) {
    val client : HttpClient =
        HttpClient(OkHttp) {

            install(JsonFeature) {
                serializer = KotlinxSerializer()
            }

            engine {
                addInterceptor(ChuckerInterceptor.Builder(context).build())
            }

            install(HttpTimeout){
                requestTimeoutMillis = TIME_OUT
                connectTimeoutMillis = TIME_OUT
                socketTimeoutMillis = TIME_OUT
            }

            install(Logging){
                logger = Logger.DEFAULT
                level = LogLevel.BODY //or ALL
                level = LogLevel.ALL
            }

            /*engine {
                connectTimeout = 5000
                socketTimeout = 5000
            }*/

        }

    companion object {
        const val TIME_OUT = 5000L
    }

}
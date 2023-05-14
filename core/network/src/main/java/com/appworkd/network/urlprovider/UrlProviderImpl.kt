package com.appworkd.network.urlprovider

import com.appworkd.network.BuildConfig
import javax.inject.Inject

class UrlProviderImpl
@Inject
constructor() : UrlProvider {
    private companion object {
        const val BASE_URL_DEBUG = "jsonplaceholder.typicode.com"
        const val BASE_URL_PROD = "jsonplaceholder.typicode.com" //TODO replace these
    }

    override fun invoke(): String =
        if (BuildConfig.DEBUG) BASE_URL_DEBUG
        else BASE_URL_PROD
}

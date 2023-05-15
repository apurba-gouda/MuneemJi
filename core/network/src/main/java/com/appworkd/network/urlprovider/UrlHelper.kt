package com.appworkd.network.urlprovider

interface UrlProvider {
    operator fun invoke(): String
}

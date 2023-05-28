package com.appworkd.network.serde

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.EmptySerializersModule
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.plus

//FIXME provide this class scope properly
class JsonProvider {

    fun invoke(modules: List<SerializersModule>): Json =
        Json {
            ignoreUnknownKeys = true
            encodeDefaults = true
            isLenient = false
            coerceInputValues = true
            allowSpecialFloatingPointValues = false
            serializersModule =
                modules.fold(EmptySerializersModule, SerializersModule::plus)
        }
}

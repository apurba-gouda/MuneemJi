package com.appwork.common.extensions

import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

suspend fun <T> FlowCollector<T>.emitValue(value: T) {
    emit(value) // Emit the next value in the flow
}

fun <T> SendChannel<T>.trySendValues(value: T) {
    trySend(value) // Emit the next number in the flow
}

suspend fun <T> Flow<T>.collectValues(action: suspend () -> Unit) {
    onEach { action.invoke() }
        .collect()
}

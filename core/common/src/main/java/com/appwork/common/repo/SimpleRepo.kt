package com.appwork.common.repo

import com.appwork.common.model.Status
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

open class SimpleRepo<D> : Repo<D> {
    private val mutableValueStream = MutableStateFlow<D?>(null)
    override val values: Flow<D?> get() = mutableValueStream

    private val mutableStatusStream = MutableStateFlow(Status.LIVE)
    override val statusStream: Flow<Status> get() = mutableStatusStream

    override val lastValue: D? get() = mutableValueStream.value
    override val lastStatus: Status get() = mutableStatusStream.value

    override suspend fun update(refreshStreams: suspend () -> D) {
        mutableStatusStream.value = Status.LOADING

        try {
            val value = refreshStreams()
            mutableValueStream.value = value
            mutableStatusStream.value = Status.LIVE
        } catch (e: Exception) {
            mutableStatusStream.value = Status.ERROR
            throw Exception("Exception while refreshing repo wih reason :${e.message}")
        }
    }
}
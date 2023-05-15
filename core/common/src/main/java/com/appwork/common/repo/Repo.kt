package com.appwork.common.repo

import com.appwork.common.model.Status
import kotlinx.coroutines.flow.Flow

interface Repo<D> {
    val values: Flow<D?>
    val statusStream: Flow<Status>

    val lastValue: D?
    val lastStatus: Status

    suspend fun update(refreshStreams: suspend () -> D)
}

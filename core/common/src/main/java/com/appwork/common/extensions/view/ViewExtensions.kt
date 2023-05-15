package com.appwork.common.extensions.view

import android.view.View
import com.appwork.common.extensions.trySendValues
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

fun View.clicks() = callbackFlow {
    val listener = View.OnClickListener {
        this.channel.trySendValues(Unit)
    }

    setOnClickListener(listener)

    awaitClose { setOnClickListener(null) }
}

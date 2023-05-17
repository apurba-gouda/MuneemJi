package com.appwork.common.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object DispatchersWrapper {
    // This will be used for cpu computations
    val Default : CoroutineDispatcher
        get() = Dispatchers.Default

    // This will be used for I/O operation like Network/ DB, file
    val IO: CoroutineDispatcher
        get() = Dispatchers.IO

    // This will be used for UI operations
    val Main : CoroutineDispatcher
        get() = Dispatchers.Main

    // NO specific usage
    val Unconfined : CoroutineDispatcher
        get() = Dispatchers.Unconfined
}

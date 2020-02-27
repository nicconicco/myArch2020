package com.nicco.core.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.SupervisorJob

open class BaseViewModel(
    application: Application,
    mainDispacher: CoroutineDispatcher,
    ioDispacher: CoroutineDispatcher
) :  AndroidViewModel(application), CoroutineScope {

    val job = SupervisorJob()
    val uiScope = CoroutineScope(mainDispacher + job)
    val ioScope = CoroutineScope(ioDispacher + job)

    override val coroutineContext: CoroutineContext
        get() = (Dispatchers.Default + job)

    override fun onCleared() {
        job.cancel()
    }
}
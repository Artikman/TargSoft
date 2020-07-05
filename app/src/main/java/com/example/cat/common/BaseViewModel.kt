package com.example.cat.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<T>(private val uiContext: CoroutineContext) : ViewModel(), CoroutineScope {

    abstract fun handleEvent(event: T)

    private var jobTracker: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = uiContext + jobTracker
}
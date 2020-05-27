package com.dj.baselibs.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.*
import timber.log.Timber

open class BaseViewModel : ViewModel() {

    fun <T> execute(task: suspend () -> T): Flow<T> {
        return flow {
            val result = task()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}
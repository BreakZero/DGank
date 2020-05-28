package com.dj.baselibs.ui

import androidx.lifecycle.ViewModel
import com.dj.baselibs.model.DataSource
import timber.log.Timber
import java.net.UnknownHostException

open class BaseViewModel : ViewModel() {
    protected fun <T> handleError(throwable: Throwable): DataSource<T> {
        Timber.e(throwable)
        return when(throwable) {
            is UnknownHostException -> {
                DataSource.error<T>("network error", null)
            }
            else -> {
                DataSource.error<T>("unknown error", null)
            }
        }
    }
}
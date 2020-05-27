package com.dj.baselibs.ui

import android.app.Application
import timber.log.Timber

open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
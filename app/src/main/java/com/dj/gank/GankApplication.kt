package com.dj.gank

import com.dj.baselibs.ui.BaseApplication
import com.dj.gank.koin.appModule
import com.dj.gank.koin.ganhuoModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Dougie
 * on 2020/5/24
 */
class GankApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GankApplication)
            modules(
                listOf(
                    appModule,
                    ganhuoModule
                )
            )
        }
    }
}
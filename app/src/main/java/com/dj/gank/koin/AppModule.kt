package com.dj.gank.koin

import com.dj.gank.remote.GankClient
import org.koin.dsl.module

/**
 * Created by Dougie
 * on 2020/5/24
 */

val appModule = module {
    single {
        GankClient.instantClient()
    }
}
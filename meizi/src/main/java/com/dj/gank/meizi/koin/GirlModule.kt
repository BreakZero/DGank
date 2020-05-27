package com.dj.gank.meizi.koin

import com.dj.gank.meizi.MeiziFragment
import com.dj.gank.meizi.MeiziViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Dougie
 * on 2020/5/25
 */
val girlModule = module {
    viewModel {
        MeiziViewModel()
    }
}
package com.dj.gank.koin

import com.dj.gank.feature.ganhuo.content.GanHuoContentFragment
import com.dj.gank.feature.ganhuo.content.GanHuoContentViewModel
import com.dj.gank.feature.ganhuo.index.GanHuoFragment
import com.dj.gank.feature.ganhuo.index.GanHuoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Dougie
 * on 2020/5/24
 */
val ganhuoModule = module {
    scope<GanHuoFragment> {
        viewModel {
            GanHuoViewModel()
        }
    }
    scope<GanHuoContentFragment> {
        viewModel {
            GanHuoContentViewModel()
        }
    }
}
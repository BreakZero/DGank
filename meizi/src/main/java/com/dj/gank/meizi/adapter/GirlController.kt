package com.dj.gank.meizi.adapter

import com.airbnb.epoxy.TypedEpoxyController
import com.dj.gank.meizi.koin.girlModule
import com.dj.gank.model.resp.GanHuoInfo
import com.dj.gank.rvItemGanhuo

/**
 * Created by Dougie
 * on 2020/5/24
 */
class GirlController : TypedEpoxyController<List<GanHuoInfo>>() {
    override fun buildModels(data: List<GanHuoInfo>) {
        data.forEach {
            girl {
                id(it.id)
                data(it)
            }
        }
    }
}

package com.dj.gank.feature.ganhuo.content.adapter

import com.airbnb.epoxy.TypedEpoxyController
import com.dj.gank.model.resp.GanHuoInfo
import com.dj.gank.rvItemGanhuo

/**
 * Created by Dougie
 * on 2020/5/24
 */
class GanHuoController : TypedEpoxyController<List<GanHuoInfo>>() {
    override fun buildModels(data: List<GanHuoInfo>) {
        if (data.isEmpty()) {
            emptyView {
                id("EmptyView")
            }
        } else {
            data.forEach {
                rvItemGanhuo {
                    id(it.id)
                    itemModel(it)
                }
            }
        }
    }
}

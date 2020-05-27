package com.dj.gank.meizi.adapter

import androidx.appcompat.widget.AppCompatImageView
import coil.api.load
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.dj.gank.common.KotlinEpoxyHolder
import com.dj.gank.meizi.R
import com.dj.gank.model.resp.GanHuoInfo
import com.google.android.material.textview.MaterialTextView

@EpoxyModelClass(layout = R.layout.rv_item_meizi)
abstract class GirlModel : EpoxyModelWithHolder<Holder>() {
    @EpoxyAttribute
    lateinit var data: GanHuoInfo

    override fun bind(holder: Holder) {
        holder.ivGirl.load(data.images.first())
        holder.tvGirlDesc.text = data.desc
    }
}

class Holder : KotlinEpoxyHolder() {
    val ivGirl by bind<AppCompatImageView>(R.id.ivGirl)
    val tvGirlDesc by bind<MaterialTextView>(R.id.tvGirlDesc)
}

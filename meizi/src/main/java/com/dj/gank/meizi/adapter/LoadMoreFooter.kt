package com.dj.gank.meizi.adapter

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import com.airbnb.epoxy.ModelView

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class LoadMoreFooter(context: Context) : FrameLayout(context) {
    init {
        View.inflate(context, com.dj.baselibs.R.layout.footer_loading, this)
    }
}

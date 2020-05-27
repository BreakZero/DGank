package com.dj.gank.feature.ganhuo.content.adapter

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import com.airbnb.epoxy.ModelView
import com.dj.gank.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_MATCH_HEIGHT)
class EmptyView(context: Context) : FrameLayout(context) {
    init {
        View.inflate(context, R.layout.empty_view, this)
    }
}

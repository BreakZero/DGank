package com.dj.baselibs.commons

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load

/**
 * Created by Dougie
 * on 2020/5/24
 */
object BaseBindingAdapter {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.loadImage(imageUrl: String?) {
        this.load(imageUrl) {
            crossfade(true)
        }
    }
}

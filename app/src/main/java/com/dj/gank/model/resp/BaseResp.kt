package com.dj.gank.model.resp

import com.google.gson.annotations.SerializedName

/**
 * Created by Dougie
 * on 2020/5/28
 */
data class BaseResp<out T>(
    @SerializedName("data")
    val `data`: T,
    @SerializedName("status")
    val status: Int
)
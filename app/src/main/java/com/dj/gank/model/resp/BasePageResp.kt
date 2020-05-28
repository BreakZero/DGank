package com.dj.gank.model.resp

import com.google.gson.annotations.SerializedName

/**
 * Created by Dougie
 * on 2020/5/28
 */
data class BasePageResp<out T>(
    @SerializedName("data")
    val `data`: T,
    @SerializedName("page")
    val page: Int,
    @SerializedName("page_count")
    val pageCount: Int,
    @SerializedName("status")
    val status: Int,
    @SerializedName("total_counts")
    val totalCounts: Int
)
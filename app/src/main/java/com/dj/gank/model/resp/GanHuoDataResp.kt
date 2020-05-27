package com.dj.gank.model.resp


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class GanHuoDataResp(
    @SerializedName("data")
    val `data`: List<GanHuoInfo>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("page_count")
    val pageCount: Int,
    @SerializedName("status")
    val status: Int,
    @SerializedName("total_counts")
    val totalCounts: Int
)
package com.dj.gank.model.resp


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CategoryResp(
    @SerializedName("data")
    val `data`: List<Category>,
    @SerializedName("status")
    val status: Int
)
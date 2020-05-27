package com.dj.gank.model.resp


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class GanHuoInfo(
    @SerializedName("author")
    val author: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("likeCounts")
    val likeCounts: Int,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("stars")
    val stars: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("views")
    val views: Int
)
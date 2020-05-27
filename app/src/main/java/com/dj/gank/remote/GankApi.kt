package com.dj.gank.remote

import com.dj.gank.model.resp.CategoryResp
import com.dj.gank.model.resp.GanHuoDataResp
import retrofit2.http.GET
import retrofit2.http.Path

interface GankApi {
    @GET("categories/GanHuo")
    suspend fun getGanHuoCategories(): CategoryResp

    @GET("data/category/GanHuo/type/{type}/page/{page}/count/20")
    suspend fun getGanHuoDataFromType(
        @Path("type") type: String,
        @Path("page") page: Int
    ): GanHuoDataResp

    @GET("data/category/Girl/type/Girl/page/{page}/count/20")
    suspend fun getGirlData(
        @Path("page") page: Int
    ): GanHuoDataResp
}
package com.dj.baselibs.model

/**
 * Created by Dougie
 * on 2020/5/28
 */
data class DataSource<out T>(
    val status: Status,
    val data: T?,
    val error: String?
) {
    companion object {
        fun <T> success(data: T?): DataSource<T> {
            return DataSource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T?): DataSource<T> {
            return DataSource(Status.ERROR, data, message)
        }

        fun <T> loading(): DataSource<T> {
            return DataSource(Status.LOADING, null, null)
        }
    }
}
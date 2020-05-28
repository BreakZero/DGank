package com.dj.gank.meizi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.dj.baselibs.ui.BaseViewModel
import com.dj.gank.model.resp.GanHuoInfo
import com.dj.gank.remote.GankApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import timber.log.Timber

/**
 * Created by Dougie
 * on 2020/5/24
 */
class MeiziViewModel : BaseViewModel(), KoinComponent {
    private val gankApi by inject<GankApi>()
    private var currPage = 1

    private val _listData = MutableLiveData<List<GanHuoInfo>>()
    val listData = Transformations.map(_listData) { it }

    fun fetch() {
        currPage = 1
        canLoadMore = true
        viewModelScope.launch {
            flow {
                val result = gankApi.getGirlData(currPage)
                emit(result)
            }.flowOn(Dispatchers.IO)
                .catch {
                    Timber.e(it)
                }.map {
                    canLoadMore = it.pageCount > 1
                    it.data
                }.collect {
                    _listData.postValue(it)
                }
        }
    }

    var canLoadMore = true

    fun loadMore() {
        viewModelScope.launch {
            flow {
                val result = gankApi.getGirlData(++currPage)
                emit(result)
            }.flowOn(Dispatchers.IO)
                .catch {
                    Timber.e(it)
                }.map {
                    canLoadMore = it.pageCount > currPage
                    it.data
                }.collect {
                    val result = mutableListOf<GanHuoInfo>().apply {
                        addAll(_listData.value ?: listOf())
                    }
                    result.addAll(it)
                    _listData.postValue(result)
                }
        }
    }
}
package com.dj.gank.feature.ganhuo.content

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
class GanHuoContentViewModel : BaseViewModel(), KoinComponent {
    private val gankApi by inject<GankApi>()
    private var currPage = 1

    private val _listData = MutableLiveData<List<GanHuoInfo>>()
    val listData = Transformations.map(_listData) { it }

    fun fetch(type: String) {
        viewModelScope.launch {
            flow {
                val result = gankApi.getGanHuoDataFromType(type = type, page = currPage)
                emit(result)
            }.flowOn(Dispatchers.IO)
                .catch {
                    _listData.postValue(emptyList())
                    Timber.e(it)
                }.map {
                    it.data
                }.collect {
                    _listData.postValue(it)
                }
        }
    }
}
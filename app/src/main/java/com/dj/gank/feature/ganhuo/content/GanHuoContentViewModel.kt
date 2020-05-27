package com.dj.gank.feature.ganhuo.content

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.dj.baselibs.ui.BaseViewModel
import com.dj.gank.model.resp.GanHuoInfo
import com.dj.gank.remote.GankApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import timber.log.Timber
import java.sql.Time

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
        execute {
            gankApi.getGanHuoDataFromType(type = type, page = currPage)
        }.onEach {
            _listData.postValue(it.data)
        }.catch {
            Timber.e("=====$it")
        }.launchIn(viewModelScope)
    }
}
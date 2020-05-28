 package com.dj.gank.feature.ganhuo.index

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.dj.baselibs.model.DataSource
import com.dj.baselibs.ui.BaseViewModel
import com.dj.gank.model.resp.Category
import com.dj.gank.remote.GankApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Dougie
 * on 2020/5/24
 */
class GanHuoViewModel : BaseViewModel(), KoinComponent {
    private val gankApi by inject<GankApi>()

    private val _categories = MutableLiveData<DataSource<List<Category>>>()
    val categories = Transformations.map(_categories) {
        it
    }

    fun fetch() {
        viewModelScope.launch {
            flow {
                emit(DataSource.loading<List<Category>>())
                val result = gankApi.getGanHuoCategories()
                emit(DataSource.success(result.data))
            }.flowOn(Dispatchers.IO)
                .catch {
                    emit(handleError(it))
                }.collect {
                    _categories.postValue(it)
                }
        }
    }
}
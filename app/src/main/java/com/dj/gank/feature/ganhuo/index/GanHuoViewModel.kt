package com.dj.gank.feature.ganhuo.index

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.dj.baselibs.ui.BaseViewModel
import com.dj.gank.model.resp.Category
import com.dj.gank.remote.GankApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject
import timber.log.Timber

/**
 * Created by Dougie
 * on 2020/5/24
 */
class GanHuoViewModel : BaseViewModel(), KoinComponent {
    private val gankApi by inject<GankApi>()

    private val _categories = MutableLiveData<List<Category>>()
    val categories = Transformations.map(_categories) {
        it
    }

    fun fetch() {
        execute {
            gankApi.getGanHuoCategories()
        }.map {
            it.data
        }.onEach {
            _categories.postValue(it)
        }.catch {
            Timber.e("GANHUO$it")
        }.launchIn(viewModelScope)
    }
}
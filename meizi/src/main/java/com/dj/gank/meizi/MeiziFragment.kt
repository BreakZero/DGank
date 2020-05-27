package com.dj.gank.meizi

import android.os.Bundle
import androidx.lifecycle.Observer
import com.dj.baselibs.ui.BaseFragment
import com.dj.gank.meizi.adapter.GirlController
import com.dj.gank.meizi.koin.girlModule
import kotlinx.android.synthetic.main.fragment_meizi.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.core.context.loadKoinModules
import timber.log.Timber

/**
 * Created by Dougie
 * on 2020/5/24
 */
class MeiziFragment : BaseFragment(R.layout.fragment_meizi) {

    private val viewModel by viewModel<MeiziViewModel>()

    private val girlController = GirlController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(girlModule)
    }

    override fun setupView() {
        super.setupView()
        girlList.setController(girlController)

        girlRefreshLayout.isRefreshing = true
        girlRefreshLayout.setOnRefreshListener {
            viewModel.fetch()
        }
        viewModel.fetch()
    }

    override fun applyViewModel() {
        super.applyViewModel()
        viewModel.apply {
            listData.observe(this@MeiziFragment, Observer {
                girlRefreshLayout.isRefreshing = false
                Timber.d(it.toString())
                girlController.setData(it)
            })
        }
    }
}
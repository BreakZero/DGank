package com.dj.gank.meizi

import android.graphics.Color
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dj.baselibs.commons.helper.GridItemDecoration
import com.dj.baselibs.commons.helper.LoadMoreRecyclerViewScrollListener
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
import kotlin.properties.Delegates

/**
 * Created by Dougie
 * on 2020/5/24
 */
class MeiziFragment : BaseFragment(R.layout.fragment_meizi) {

    private val viewModel by viewModel<MeiziViewModel>()

    private val girlController = GirlController()
    private var loadMoreRecyclerViewScrollListener by Delegates.notNull<LoadMoreRecyclerViewScrollListener>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(girlModule)
    }

    override fun setupView() {
        super.setupView()
        loadMoreRecyclerViewScrollListener = object :
            LoadMoreRecyclerViewScrollListener(girlList.layoutManager as GridLayoutManager) {
            override fun fetchMore() {
                viewModel.loadMore()
            }
        }
        girlList.addOnScrollListener(loadMoreRecyclerViewScrollListener)
        girlList.addItemDecoration(
            GridItemDecoration(
                requireContext(),
                GridItemDecoration.ALL
            ).apply {
                setDividerColor(Color.WHITE)
            })
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
                girlController.setData(it, viewModel.canLoadMore)
            })
        }
    }
}
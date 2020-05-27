package com.dj.gank.feature.ganhuo.content

import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import com.dj.baselibs.ui.BaseFragment
import com.dj.gank.R
import com.dj.gank.feature.ganhuo.content.adapter.GanHuoController
import kotlinx.android.synthetic.main.fragment_ganhuo_content.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

/**
 * Created by Dougie
 * on 2020/5/24
 */
class GanHuoContentFragment : BaseFragment(R.layout.fragment_ganhuo_content) {
    private val viewModel by lifecycleScope.viewModel<GanHuoContentViewModel>(this)

    private val controller = GanHuoController()

    companion object {
        fun newInstance(title: String = ""): GanHuoContentFragment {
            return GanHuoContentFragment().apply {
                arguments = bundleOf("TITLE" to title)
            }
        }
    }

    override fun setupView() {
        super.setupView()
        val title = arguments?.getString("TITLE") ?: "Title"
        listContent.setController(controller)
        refreshLayout.isRefreshing = true
        refreshLayout.setOnRefreshListener {
            viewModel.fetch(title)
        }
        viewModel.fetch(title)
    }

    override fun applyViewModel() {
        super.applyViewModel()
        viewModel.apply {
            listData.observe(this@GanHuoContentFragment, Observer {
                refreshLayout.isRefreshing = false
                controller.setData(it)
            })
        }
    }
}
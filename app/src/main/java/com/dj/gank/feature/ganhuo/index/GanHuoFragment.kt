package com.dj.gank.feature.ganhuo.index

import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dj.baselibs.ui.BaseFragment
import com.dj.gank.R
import com.dj.gank.feature.ganhuo.content.GanHuoContentFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_ganhuo.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel
import kotlin.properties.Delegates

/**
 * Created by Dougie
 * on 2020/5/24
 */
class GanHuoFragment : BaseFragment(R.layout.fragment_ganhuo) {
    private val viewModel by lifecycleScope.viewModel<GanHuoViewModel>(this)

    private var fragmentStateAdapter by Delegates.notNull<BaseFragmentStateAdapter>()

    override fun setupView() {
        super.setupView()
        viewModel.fetch()

        fragmentStateAdapter = BaseFragmentStateAdapter(this)
    }

    override fun applyViewModel() {
        super.applyViewModel()
        viewModel.apply {
            categories.observe(this@GanHuoFragment, Observer {
                if (fragmentStateAdapter.isExist()) return@Observer
                it.forEach {
                    fragmentStateAdapter.add(GanHuoContentFragment.newInstance(it.title))
                }
                ganhuoViewPager.adapter = fragmentStateAdapter
                val tabLayoutMediator =
                    TabLayoutMediator(ganhuoTab, ganhuoViewPager,
                        TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                            tab.text = it[position].title
                        })
                tabLayoutMediator.attach()
            })
        }
    }
}

class BaseFragmentStateAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val fragments = mutableListOf<Fragment>()

    fun isExist() = fragments.size > 0

    fun add(fragment: Fragment) {
        fragments.add(fragment)
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}

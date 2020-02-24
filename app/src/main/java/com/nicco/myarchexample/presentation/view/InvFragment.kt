package com.nicco.myarchexample.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.nicco.core.fake.DummyCategoryData.categories
import com.nicco.myarchexample.R
import com.nicco.myarchexample.databinding.FragmentInvBinding
import com.nicco.myarchexample.di.*
import com.nicco.myarchexample.presentation.model.InvModel
import com.nicco.myarchexample.presentation.view.adapter.CategoryDiffUtilAdapter
import com.nicco.myarchexample.presentation.view.adapter.InvListAdapter
import com.nicco.myarchexample.presentation.viewmodel.InvViewAction
import com.nicco.myarchexample.presentation.viewmodel.InvViewModel
import kotlinx.android.synthetic.main.fragment_inv.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules


class InvFragment : Fragment(),
    InvListAdapter.Interaction {

    val adapterRF = CategoryDiffUtilAdapter()
    val adapterRV = CategoryDiffUtilAdapter()
    private val invListAdapter: InvListAdapter by inject()
    private val invViewModel: InvViewModel by viewModel()

    private fun injectDependencies() = loadFeatures
    private val loadFeatures by lazy {
        loadKoinModules(
            listOf(
                invAdapterModule,
                invViewModelModule,
                invRepositoryModule,
                invDataSourceModule,
                invApiModule,
                invDispatchersProvideModule
            )
        )
    }

    companion object {
        fun newInstance() =
            InvFragment()
    }

    override fun InvClicked(inv: InvModel) {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        injectDependencies()
        invListAdapter.interaction = this

        return FragmentInvBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            rvInv.adapter = invListAdapter
            rvInv.isNestedScrollingEnabled = false
            vpRendaFixa.adapter = adapterRF
            vpRendaVariavel.adapter = adapterRV
            configurateViewPager(vpRendaFixa)
            configurateViewPager(vpRendaVariavel)
            subcribeListeners()
        }.root
    }

    private fun configurateViewPager(viewPager2: ViewPager2) {
        with(viewPager2) {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
        }

        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val offsetPx = resources.getDimensionPixelOffset(R.dimen.offset)
        viewPager2.setPageTransformer { page, position ->
            val viewPager = page.parent.parent as ViewPager2
            val offset = position * -(2 * offsetPx + pageMarginPx)
            if (viewPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
                if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                    page.translationX = -offset
                } else {
                    page.translationX = offset
                }
            } else {
                page.translationY = offset
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterRF.submitList(categories)
        adapterRV.submitList(categories)
    }

    private fun subcribeListeners() {
        invViewModel.actionView.observe(viewLifecycleOwner) { state ->
            when (state) {
                is InvViewAction.InvLoading -> {
                    if(state.loading) {
                        progress.visibility = View.VISIBLE
                    } else {
                        progress.visibility = View.GONE
                    }
                }
                is InvViewAction.InvSuccess -> {
                    invListAdapter.swapData(state.itens)
                }
                is InvViewAction.InvError -> {

                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        unloadKoinModules(
            listOf(
                invAdapterModule,
                invViewModelModule,
                invRepositoryModule,
                invDataSourceModule,
                invApiModule,
                invDispatchersProvideModule
            )
        )
    }
}
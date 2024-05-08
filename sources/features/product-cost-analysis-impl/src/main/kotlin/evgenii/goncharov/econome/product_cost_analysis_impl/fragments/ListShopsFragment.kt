package evgenii.goncharov.econome.product_cost_analysis_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.product_cost_analysis_api.di.ListShopsApi
import evgenii.goncharov.econome.product_cost_analysis_impl.di.contracts.ListShopsInternal
import evgenii.goncharov.econome.product_cost_analysis_impl.ui.ListShopsScreen
import evgenii.goncharov.econome.product_cost_analysis_impl.view.models.ListShopsViewModel

/**
 * 18. Screen
 */
internal class ListShopsFragment : CoreFragment() {

    private val dependency: ListShopsInternal by lazy {
        getFeatureApi(ListShopsApi::class.java) as ListShopsInternal
    }
    private val viewModel: ListShopsViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = ListShopsScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(ListShopsApi::class.java)
    }

    companion object {

        fun newInstance() = ListShopsFragment()
    }
}
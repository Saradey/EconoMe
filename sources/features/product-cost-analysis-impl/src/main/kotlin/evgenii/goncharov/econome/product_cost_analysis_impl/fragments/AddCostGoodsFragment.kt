package evgenii.goncharov.econome.product_cost_analysis_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.product_cost_analysis_api.di.AddCostGoodsApi
import evgenii.goncharov.econome.product_cost_analysis_impl.di.contracts.AddCostGoodsInternal
import evgenii.goncharov.econome.product_cost_analysis_impl.ui.AddCostGoodsScreen
import evgenii.goncharov.econome.product_cost_analysis_impl.view.models.AddCostGoodsViewModel

/**
 * 19. Screen
 */
internal class AddCostGoodsFragment : CoreFragment() {

    private val dependency: AddCostGoodsInternal by lazy {
        getFeatureApi(AddCostGoodsApi::class.java) as AddCostGoodsInternal
    }
    private val viewModel: AddCostGoodsViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = AddCostGoodsScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(AddCostGoodsApi::class.java)
    }

    companion object {
        fun newInstance() = AddCostGoodsFragment()
    }
}
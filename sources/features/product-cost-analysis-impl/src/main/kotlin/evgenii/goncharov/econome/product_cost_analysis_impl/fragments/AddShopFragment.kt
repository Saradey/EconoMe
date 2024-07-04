package evgenii.goncharov.econome.product_cost_analysis_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.di_core.extensions.getFeatureApi
import evgenii.goncharov.econome.di_core.extensions.releaseFeatureApi
import evgenii.goncharov.econome.product_cost_analysis_api.di.AddShopApi
import evgenii.goncharov.econome.product_cost_analysis_impl.di.contracts.AddShopInternal
import evgenii.goncharov.econome.product_cost_analysis_impl.ui.AddShopScreen
import evgenii.goncharov.econome.product_cost_analysis_impl.view.models.AddShopViewModel

/**
 * 20. Screen
 */
internal class AddShopFragment : CoreFragment() {

    private val dependency: AddShopInternal by lazy {
        getFeatureApi(AddShopApi::class.java) as AddShopInternal
    }
    private val viewModel: AddShopViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = AddShopScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(AddShopApi::class.java)
    }

    companion object {

        fun newInstance() = AddShopFragment()
    }
}
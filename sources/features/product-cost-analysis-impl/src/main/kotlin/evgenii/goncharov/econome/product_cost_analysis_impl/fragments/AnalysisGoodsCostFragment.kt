package evgenii.goncharov.econome.product_cost_analysis_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.product_cost_analysis_api.di.AnalysisGoodsCostApi
import evgenii.goncharov.econome.product_cost_analysis_impl.di.contracts.AnalysisGoodsCostInternal
import evgenii.goncharov.econome.product_cost_analysis_impl.ui.AnalysisGoodsCostScreen
import evgenii.goncharov.econome.product_cost_analysis_impl.view.models.AnalysisGoodsCostViewModel

/**
 * 23. Screen
 */
internal class AnalysisGoodsCostFragment : CoreFragment() {

    private val dependency: AnalysisGoodsCostInternal by lazy {
        getFeatureApi(AnalysisGoodsCostApi::class.java) as AnalysisGoodsCostInternal
    }
    private val viewModel: AnalysisGoodsCostViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = AnalysisGoodsCostScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(AnalysisGoodsCostApi::class.java)
    }

    companion object {

        fun newInstance() = AnalysisGoodsCostFragment()
    }
}
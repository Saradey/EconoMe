package evgenii.goncharov.econome.finance_analysis_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.finance_analysis_api.di.FinanceAnalyticsApi
import evgenii.goncharov.econome.finance_analysis_impl.di.contracts.FinanceAnalyticsInternal
import evgenii.goncharov.econome.finance_analysis_impl.ui.FinanceAnalyticsScreen
import evgenii.goncharov.econome.finance_analysis_impl.view.models.FinanceAnalyticsViewModel

internal class FinanceAnalyticsFragment : CoreFragment() {

    private val dependency: FinanceAnalyticsInternal by lazy {
        getFeatureApi(FinanceAnalyticsApi::class.java) as FinanceAnalyticsInternal
    }
    private val viewModel: FinanceAnalyticsViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = FinanceAnalyticsScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(FinanceAnalyticsApi::class.java)
    }

    companion object {

        fun newInstance() = FinanceAnalyticsFragment()
    }
}
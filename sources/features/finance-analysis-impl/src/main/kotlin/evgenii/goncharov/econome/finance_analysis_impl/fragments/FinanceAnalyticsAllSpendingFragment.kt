package evgenii.goncharov.econome.finance_analysis_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.di_core.extensions.getFeatureApi
import evgenii.goncharov.econome.di_core.extensions.releaseFeatureApi
import evgenii.goncharov.econome.finance_analysis_api.di.FinanceAnalyticsAllSpendingApi
import evgenii.goncharov.econome.finance_analysis_impl.di.contracts.FinanceAnalyticsAllSpendingInternal
import evgenii.goncharov.econome.finance_analysis_impl.ui.FinanceAnalyticsAllSpendingScreen
import evgenii.goncharov.econome.finance_analysis_impl.view.models.FinanceAnalyticsAllSpendingViewModel

/**
 * 13. Screen
 */
internal class FinanceAnalyticsAllSpendingFragment : CoreFragment() {

    private val dependency: FinanceAnalyticsAllSpendingInternal by lazy {
        getFeatureApi(FinanceAnalyticsAllSpendingApi::class.java) as FinanceAnalyticsAllSpendingInternal
    }
    private val viewModel: FinanceAnalyticsAllSpendingViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = FinanceAnalyticsAllSpendingScreen(
        goToFinanceAnalytics = viewModel::navigateToFinanceAnalytics
    )

    override fun releaseDependencies() {
        releaseFeatureApi(FinanceAnalyticsAllSpendingApi::class.java)
    }

    companion object {

        fun newInstance() = FinanceAnalyticsAllSpendingFragment()
    }
}
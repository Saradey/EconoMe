package evgenii.goncharov.econome.finance_analysis_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.finance_analysis_api.navigation.FinanceAnalyticsAllSpendingLauncher
import javax.inject.Inject

internal class FinanceAnalyticsAllSpendingViewModel @Inject constructor(
    private val financeAnalyticsAllSpendingLauncher: FinanceAnalyticsAllSpendingLauncher
) : ViewModel() {

    fun navigateToFinanceAnalytics() {
        financeAnalyticsAllSpendingLauncher.deepLaunchFinanceAnalytics()
    }
}
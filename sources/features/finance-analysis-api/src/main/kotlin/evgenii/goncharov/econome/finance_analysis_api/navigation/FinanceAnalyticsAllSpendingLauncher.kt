package evgenii.goncharov.econome.finance_analysis_api.navigation

import evgenii.goncharov.econome.di_core.contracts.BaseLauncher

public interface FinanceAnalyticsAllSpendingLauncher : BaseLauncher {

    public fun deepLaunchAllSpendingAnalytics()

    public fun deepLaunchFinanceAnalytics()
}
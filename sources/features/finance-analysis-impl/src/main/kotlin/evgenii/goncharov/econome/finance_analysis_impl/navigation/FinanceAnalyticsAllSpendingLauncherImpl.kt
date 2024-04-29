package evgenii.goncharov.econome.finance_analysis_impl.navigation

import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.finance_analysis_api.navigation.FinanceAnalyticsAllSpendingLauncher
import evgenii.goncharov.econome.navigation.utils.DEEP_ROUTER
import javax.inject.Inject
import javax.inject.Named

public class FinanceAnalyticsAllSpendingLauncherImpl @Inject constructor(
    @Named(DEEP_ROUTER) private val deepRouter: Router
) : FinanceAnalyticsAllSpendingLauncher {

    override fun deepLaunchAllSpendingAnalytics() {
        deepRouter.navigateTo(
            FinanceAnalyticsAllSpendingNavigationScreens.startFinanceAnalyticsAllSpending()
        )
    }
}
package evgenii.goncharov.econome.finance_analysis_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.finance_analysis_impl.fragments.FinanceAnalyticsAllSpendingFragment

internal object FinanceAnalyticsAllSpendingNavigationScreens {

    fun startFinanceAnalyticsAllSpending() = FragmentScreen {
        FinanceAnalyticsAllSpendingFragment.newInstance()
    }
}
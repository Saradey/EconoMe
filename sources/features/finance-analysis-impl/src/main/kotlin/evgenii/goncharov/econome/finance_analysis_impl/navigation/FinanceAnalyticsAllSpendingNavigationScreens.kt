package evgenii.goncharov.econome.finance_analysis_impl.navigation

import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.finance_analysis_impl.fragments.FinanceAnalyticsAllSpendingFragment
import evgenii.goncharov.econome.finance_analysis_impl.fragments.FinanceAnalyticsFragment
import evgenii.goncharov.econome.navigation.navigation.BACKSTACK_NAME_ALL_SPENDING_ANALYSIS
import evgenii.goncharov.econome.navigation.navigation.BACKSTACK_NAME_EVERYWHERE

internal object FinanceAnalyticsAllSpendingNavigationScreens {

    fun startDeepFinanceAnalyticsAllSpending() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_ALL_SPENDING_ANALYSIS
        override fun createFragment(factory: FragmentFactory) =
            FinanceAnalyticsAllSpendingFragment.newInstance()
    }

    fun startDeepFinanceAnalytics() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_EVERYWHERE
        override fun createFragment(factory: FragmentFactory) =
            FinanceAnalyticsFragment.newInstance()
    }
}
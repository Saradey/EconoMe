package evgenii.goncharov.econome.product_cost_analysis_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.product_cost_analysis_impl.fragments.ListShopsFragment

internal object ProductCostAnalysisNavigationScreens {

    fun startDeepListShops() = FragmentScreen {
        ListShopsFragment.newInstance()
    }
}
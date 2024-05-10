package evgenii.goncharov.econome.product_cost_analysis_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.navigation.navigation.BACKSTACK_NAME_EVERYWHERE
import evgenii.goncharov.econome.product_cost_analysis_impl.fragments.AddCostGoodsFragment
import evgenii.goncharov.econome.product_cost_analysis_impl.fragments.AddShopFragment
import evgenii.goncharov.econome.product_cost_analysis_impl.fragments.ListShopsFragment

internal object ProductCostAnalysisNavigationScreens {

    fun startDeepListShops() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_EVERYWHERE
        override fun createFragment(factory: FragmentFactory): Fragment {
            return ListShopsFragment.newInstance()
        }
    }

    fun startDeepAddCostGoods() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_EVERYWHERE
        override fun createFragment(factory: FragmentFactory): Fragment {
            return AddCostGoodsFragment.newInstance()
        }
    }

    fun startDeepAddShop() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_EVERYWHERE
        override fun createFragment(factory: FragmentFactory): Fragment {
            return AddShopFragment.newInstance()
        }
    }
}
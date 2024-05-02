package evgenii.goncharov.econome.all_spending_impl.navigation

import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.all_spending_impl.fragments.AllSpendingFragment
import evgenii.goncharov.econome.navigation.navigation.BACKSTACK_NAME_ALL_SPENDING

internal object AllSpendingNavigationScreens {

    fun startDeepAllSpending() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_ALL_SPENDING
        override fun createFragment(factory: FragmentFactory) = AllSpendingFragment.newInstance()
    }
}
package evgenii.goncharov.econome.all_spending_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.all_spending_impl.fragments.AllSpendingFragment

internal object AllSpendingNavigationScreens {

    fun startAllSpending() = FragmentScreen {
        AllSpendingFragment.newInstance()
    }
}
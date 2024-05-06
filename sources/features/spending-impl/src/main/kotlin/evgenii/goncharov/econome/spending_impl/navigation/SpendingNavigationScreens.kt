package evgenii.goncharov.econome.spending_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.spending_impl.fragments.AddSpendingDialogFragment

internal object SpendingNavigationScreens {

    fun startAddSpending() = FragmentScreen {
        AddSpendingDialogFragment.newInstance()
    }
}
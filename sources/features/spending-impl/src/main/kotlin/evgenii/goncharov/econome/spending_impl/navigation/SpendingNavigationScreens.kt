package evgenii.goncharov.econome.spending_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.spending_impl.fragments.AddSpendingDialogFragment
import evgenii.goncharov.econome.spending_impl.fragments.SpendingInfoBottomSheetFragment

internal object SpendingNavigationScreens {

    fun startAddSpending() = FragmentScreen {
        AddSpendingDialogFragment.newInstance()
    }

    fun startDeepSpendingInfo(spendingId: Long) = FragmentScreen {
        SpendingInfoBottomSheetFragment.newInstance(spendingId)
    }
}
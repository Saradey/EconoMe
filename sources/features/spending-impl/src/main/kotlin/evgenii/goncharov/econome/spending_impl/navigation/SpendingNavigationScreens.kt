package evgenii.goncharov.econome.spending_impl.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.navigation.navigation.BACKSTACK_NAME_EVERYWHERE
import evgenii.goncharov.econome.spending_impl.fragments.AddSpendingDialogFragment
import evgenii.goncharov.econome.spending_impl.fragments.SpendingInfoFragment

internal object SpendingNavigationScreens {

    fun startAddSpending() = FragmentScreen {
        AddSpendingDialogFragment.newInstance()
    }

    fun startDeepSpendingInfo(spendingId: Long) = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_EVERYWHERE
        override fun createFragment(factory: FragmentFactory): Fragment {
            return SpendingInfoFragment.newInstance(spendingId)
        }
    }
}
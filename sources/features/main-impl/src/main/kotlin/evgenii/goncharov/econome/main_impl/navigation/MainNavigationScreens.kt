package evgenii.goncharov.econome.main_impl.navigation

import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.main_impl.fragments.MainFragment
import evgenii.goncharov.econome.main_impl.fragments.SpendingLimitDialogFragment
import evgenii.goncharov.econome.navigation.navigation.BACKSTACK_NAME_MAIN

internal object MainNavigationScreens {

    fun startDeepMain() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_MAIN
        override fun createFragment(factory: FragmentFactory) = MainFragment.newInstance()
    }

    fun startSpendingLimitDialog() = FragmentScreen {
        SpendingLimitDialogFragment.newInstance()
    }
}
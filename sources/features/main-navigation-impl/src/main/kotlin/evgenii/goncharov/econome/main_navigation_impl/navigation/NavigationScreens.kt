package evgenii.goncharov.econome.main_navigation_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.main_navigation_impl.fragments.MainNavigationFragment

internal object NavigationScreens {

    fun startMainNavigation() = FragmentScreen {
        MainNavigationFragment.newInstance()
    }
}
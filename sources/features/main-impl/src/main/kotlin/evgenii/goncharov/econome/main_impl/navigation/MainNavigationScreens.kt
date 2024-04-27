package evgenii.goncharov.econome.main_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.main_impl.fragments.MainFragment

internal object MainNavigationScreens {

    fun startMain() = FragmentScreen {
        MainFragment.newInstance()
    }
}
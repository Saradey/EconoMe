package evgenii.goncharov.econome.settings_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.settings_impl.fragments.SettingsFragment

internal object SettingsNavigationScreens {

    fun startSettings() = FragmentScreen {
        SettingsFragment.newInstance()
    }
}
package evgenii.goncharov.econome.main_navigation.navigation

import evgenii.goncharov.econome.di_core.contracts.BaseLauncher

public interface MainNavigationLauncher : BaseLauncher {

    public fun launchMainNavigation()

    public fun launchReplaceNavigation()
}
package evgenii.goncharov.econome.main_navigation_impl.navigation

import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import evgenii.goncharov.econome.navigation.utils.GLOBAL_ROUTER
import javax.inject.Inject
import javax.inject.Named

public class MainNavigationLauncherImpl @Inject constructor(
    @Named(GLOBAL_ROUTER) private val globalRouter: Router
) : MainNavigationLauncher {

    override fun launchMainNavigation() {
        globalRouter.navigateTo(NavigationScreens.startMainNavigation())
    }
}
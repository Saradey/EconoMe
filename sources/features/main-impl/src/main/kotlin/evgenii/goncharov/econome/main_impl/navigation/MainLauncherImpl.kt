package evgenii.goncharov.econome.main_impl.navigation

import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.main_api.navigation.MainLauncher
import evgenii.goncharov.econome.navigation.utils.DEEP_ROUTER
import javax.inject.Inject
import javax.inject.Named

public class MainLauncherImpl @Inject constructor(
    @Named(DEEP_ROUTER) private val deepRouter: Router
) : MainLauncher {

    override fun deepLaunchMain() {
        deepRouter.navigateTo(MainNavigationScreens.startMain())
    }
}
package evgenii.goncharov.econome.user_impl.navigation

import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.navigation.utils.GLOBAL_ROUTER
import evgenii.goncharov.econome.user_api.UserLauncher
import javax.inject.Inject
import javax.inject.Named

public class UserLauncherImpl @Inject constructor(
    @Named(GLOBAL_ROUTER) private val globalRouter: Router
) : UserLauncher {

    override fun launchUserCreator() {
        globalRouter.navigateTo(UserScreens.startUserCreator())
    }
}
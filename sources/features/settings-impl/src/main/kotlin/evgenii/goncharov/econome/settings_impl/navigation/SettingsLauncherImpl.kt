package evgenii.goncharov.econome.settings_impl.navigation

import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.navigation.utils.GLOBAL_ROUTER
import evgenii.goncharov.econome.settings_api.navigation.SettingsLauncher
import javax.inject.Inject
import javax.inject.Named

public class SettingsLauncherImpl @Inject constructor(
    @Named(GLOBAL_ROUTER) private val globalRouter: Router
) : SettingsLauncher {

    override fun launchSettings() {
        globalRouter.navigateTo(SettingsNavigationScreens.startSettings())
    }
}
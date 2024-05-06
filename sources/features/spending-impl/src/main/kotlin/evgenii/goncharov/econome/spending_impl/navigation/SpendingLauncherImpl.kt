package evgenii.goncharov.econome.spending_impl.navigation

import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.navigation.utils.DEEP_ROUTER
import evgenii.goncharov.econome.spending_api.navigation.SpendingLauncher
import javax.inject.Inject
import javax.inject.Named

public class SpendingLauncherImpl @Inject constructor(
    @Named(DEEP_ROUTER) private val deepRouter: Router
) : SpendingLauncher {

    override fun launchAddSpending() {
        deepRouter.navigateTo(SpendingNavigationScreens.startAddSpending())
    }
}
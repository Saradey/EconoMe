package evgenii.goncharov.econome.all_spending_impl.navigation

import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.all_spending_api.navigation.AllSpendingLauncher
import evgenii.goncharov.econome.navigation.utils.DEEP_ROUTER
import javax.inject.Inject
import javax.inject.Named

public class AllSpendingLauncherImpl @Inject constructor(
    @Named(DEEP_ROUTER) private val deepRouter: Router
): AllSpendingLauncher {

    override fun deepLaunchAllSpending() {
        deepRouter.navigateTo(AllSpendingNavigationScreens.startAllSpending())
    }
}
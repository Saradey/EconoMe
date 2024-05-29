package evgenii.goncharov.econome.wallet_impl.navigation

import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.navigation.utils.GLOBAL_ROUTER
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher
import javax.inject.Inject
import javax.inject.Named

public class WalletLauncherImpl @Inject constructor(
    @Named(GLOBAL_ROUTER) private val globalRouter: Router
) : WalletLauncher {

    override fun launchReplaceWalletCreator(userUuid: String) {
        globalRouter.replaceScreen(NavigationWalletScreens.startWalletCreator(userUuid))
    }

    override fun launchWalletCreator() {
        globalRouter.navigateTo(NavigationWalletScreens.startWalletCreator("TODO"))
    }

    override fun launchAllWallet() {
        globalRouter.navigateTo(NavigationWalletScreens.startWalletsList())
    }
}
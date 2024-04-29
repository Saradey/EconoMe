package evgenii.goncharov.econome.bank_accounts_impl.navigation

import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.bank_accounts_api.navigation.BankAccountsLauncher
import evgenii.goncharov.econome.navigation.utils.DEEP_ROUTER
import javax.inject.Inject
import javax.inject.Named

public class BankAccountsLauncherImpl @Inject constructor(
    @Named(DEEP_ROUTER) private val deepRouter: Router
) : BankAccountsLauncher {

    override fun deepLaunchBankAccounts() {
        deepRouter.navigateTo(BankAccountsNavigationScreens.startBankAccounts())
    }
}
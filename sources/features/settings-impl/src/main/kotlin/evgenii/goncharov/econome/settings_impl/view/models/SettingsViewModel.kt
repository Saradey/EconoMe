package evgenii.goncharov.econome.settings_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.user_api.navigation.UserLauncher
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher
import javax.inject.Inject

internal class SettingsViewModel @Inject constructor(
    private val userLauncher: UserLauncher,
    private val walletLauncher: WalletLauncher
) : ViewModel() {

    fun navigateUserCreator() {
        userLauncher.launchUserCreator()
    }

    fun navigateUserChoosing() {
        userLauncher.launchUserChoosing()
    }

    fun navigateWalletCreator() {
        walletLauncher.launchWalletCreator()
    }

    fun navigateAllWallet() {
        walletLauncher.launchAllWallet()
    }
}
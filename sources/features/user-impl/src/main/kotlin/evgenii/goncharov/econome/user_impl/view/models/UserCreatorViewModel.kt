package evgenii.goncharov.econome.user_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher
import javax.inject.Inject

internal class UserCreatorViewModel @Inject constructor(
    private val walletLauncher: WalletLauncher
) : ViewModel() {

    fun goToWalletCreator() {
        walletLauncher.launchReplaceWalletCreator()
    }
}
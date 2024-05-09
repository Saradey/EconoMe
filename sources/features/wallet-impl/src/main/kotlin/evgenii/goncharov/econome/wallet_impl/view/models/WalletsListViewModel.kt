package evgenii.goncharov.econome.wallet_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher
import javax.inject.Inject

internal class WalletsListViewModel @Inject constructor(
    private val walletLauncher: WalletLauncher
) : ViewModel() {

    fun navigateWalletCreator() {
        walletLauncher.launchWalletCreator()
    }
}
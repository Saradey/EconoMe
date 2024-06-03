package evgenii.goncharov.econome.wallet_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import evgenii.goncharov.econome.wallet_impl.repositories.WalletCreatorRepository
import javax.inject.Inject

internal class WalletCreatorViewModel @Inject constructor(
    private val mainNavigationLauncher: MainNavigationLauncher,
    private val walletCreatorRepository: WalletCreatorRepository
) : ViewModel() {

    private var currentUserId: String? = null

    fun goToMainBottomNavigation() {
        mainNavigationLauncher.launchReplaceNavigation()
    }

    fun setUserId(userId: String) {
        this.currentUserId = userId
    }

    fun inputWalletName(walletName: String) {

    }
}
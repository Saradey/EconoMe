package evgenii.goncharov.econome.main_activity.view.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import evgenii.goncharov.econome.main_activity.interactors.MainActivityInteractor
import evgenii.goncharov.econome.main_activity.models.CheckUserModel
import evgenii.goncharov.econome.main_activity.repositories.UserRepository
import evgenii.goncharov.econome.main_activity.use.cases.CheckUserUseCase
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import evgenii.goncharov.econome.user_api.navigation.UserLauncher
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class MainActivityViewModel @Inject constructor(
    private val userLauncher: UserLauncher,
    private val mainNavigationLauncher: MainNavigationLauncher,
    private val checkUserUseCase: CheckUserUseCase,
    private val walletLauncher: WalletLauncher,
    private val userRepository: UserRepository,
    private val mainActivityInteractor: MainActivityInteractor
) : ViewModel() {

    fun appStart() {
        viewModelScope.launch {
            when (checkUserUseCase()) {
                CheckUserModel.OpenMainMenu -> openMainMenu()
                CheckUserModel.OpenUserChoose -> userLauncher.launchUserChoosing()
                CheckUserModel.OpenUserCreator -> userLauncher.launchUserCreator()
                CheckUserModel.OpenWalletCreator -> walletLauncher.launchWalletCreator(
                    userRepository.getCurrentUserId()
                )
            }
        }
    }

    private fun openMainMenu() {
        viewModelScope.launch {
            mainActivityInteractor.setCurrentUserAndCurrentWallet()
            mainNavigationLauncher.launchMainNavigation()
        }
    }
}
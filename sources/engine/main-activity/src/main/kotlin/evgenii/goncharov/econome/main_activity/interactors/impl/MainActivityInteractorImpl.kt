package evgenii.goncharov.econome.main_activity.interactors.impl

import evgenii.goncharov.econome.current_user.repositories.CurrentUserRepository
import evgenii.goncharov.econome.current_user.repositories.CurrentWalletRepository
import evgenii.goncharov.econome.main_activity.interactors.MainActivityInteractor
import evgenii.goncharov.econome.main_activity.repositories.UserRepository
import evgenii.goncharov.econome.main_activity.repositories.WalletRepository
import javax.inject.Inject

internal class MainActivityInteractorImpl @Inject constructor(
    private val currentUserRepository: CurrentUserRepository,
    private val currentWalletRepository: CurrentWalletRepository,
    private val userRepository: UserRepository,
    private val walletRepository: WalletRepository
) : MainActivityInteractor {

    override suspend fun setCurrentUserAndCurrentWallet() {
        val currentUserId = userRepository.getCurrentUserId()
        currentUserRepository.setCurrentUserId(currentUserId)
        val currentWalletId = walletRepository.getCurrentWalletId()
        currentWalletRepository.setCurrentWalletId(currentWalletId)
    }
}
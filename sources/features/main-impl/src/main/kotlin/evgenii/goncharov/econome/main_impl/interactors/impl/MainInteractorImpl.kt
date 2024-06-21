package evgenii.goncharov.econome.main_impl.interactors.impl

import evgenii.goncharov.econome.current_user.repositories.CurrentUserRepository
import evgenii.goncharov.econome.current_user.repositories.CurrentWalletRepository
import evgenii.goncharov.econome.main_impl.interactors.MainInteractor
import evgenii.goncharov.econome.main_impl.models.CurrentUserModel
import evgenii.goncharov.econome.main_impl.repositories.MainRepository
import javax.inject.Inject

internal class MainInteractorImpl @Inject constructor(
    private val currentUserRepository: CurrentUserRepository,
    private val currentWalletRepository: CurrentWalletRepository,
    private val mainRepository: MainRepository
) : MainInteractor {

    private var currentUserId = ""
    private var currentWalletId = -1L

    override fun checkParameters() {
        currentUserId = currentUserRepository.getCurrentUserId() ?: throw IllegalArgumentException(
            USER_ERROR_MESSAGE
        )
        currentWalletId = currentWalletRepository.getCurrentWalletId()
            ?: throw IllegalArgumentException(WALLET_ERROR_MESSAGE)
    }

    override suspend fun formCurrentUser(): CurrentUserModel {
        val userDto = mainRepository.getUserById(currentUserId)
        val walletDto = mainRepository.getWalletById(currentWalletId)
        return CurrentUserModel(
            userName = "",
            walletName = ""
        )
    }

    private companion object {

        const val USER_ERROR_MESSAGE = "Current user cannot be null"
        const val WALLET_ERROR_MESSAGE = "Current wallet cannot be null"
    }
}
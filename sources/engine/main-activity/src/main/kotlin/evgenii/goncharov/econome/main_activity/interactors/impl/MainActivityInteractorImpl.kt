package evgenii.goncharov.econome.main_activity.interactors.impl

import evgenii.goncharov.econome.current_user.repositories.CurrentUserRepository
import evgenii.goncharov.econome.current_user.repositories.CurrentWalletRepository
import evgenii.goncharov.econome.main_activity.interactors.MainActivityInteractor
import javax.inject.Inject

internal class MainActivityInteractorImpl @Inject constructor(
    private val currentUserRepository: CurrentUserRepository,
    private val currentWalletRepository: CurrentWalletRepository
) : MainActivityInteractor {

    override fun setCurrentUserAndCurrentWallet() {

    }

    override fun setCurrentUser() {

    }
}
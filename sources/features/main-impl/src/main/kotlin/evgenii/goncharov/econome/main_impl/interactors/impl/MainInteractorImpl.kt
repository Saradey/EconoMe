package evgenii.goncharov.econome.main_impl.interactors.impl

import evgenii.goncharov.econome.current_user.repositories.CurrentUserRepository
import evgenii.goncharov.econome.current_user.repositories.CurrentWalletRepository
import evgenii.goncharov.econome.main_impl.interactors.MainInteractor
import evgenii.goncharov.econome.main_impl.models.CurrentUserModel
import evgenii.goncharov.econome.main_impl.repositories.MainRepository
import java.util.Calendar
import javax.inject.Inject

internal class MainInteractorImpl @Inject constructor(
    private val currentUserRepository: CurrentUserRepository,
    private val currentWalletRepository: CurrentWalletRepository,
    private val mainRepository: MainRepository
) : MainInteractor {

    private var currentUserId = ""
    private var currentWalletId = -1L
    private val today = Calendar.getInstance().time

    override fun checkParameters() {
        currentUserId = currentUserRepository.getCurrentUserId() ?: throw IllegalArgumentException(
            USER_ERROR_MESSAGE
        )
        currentWalletId = currentWalletRepository.getCurrentWalletId()
    }

    override suspend fun formCurrentUser(): CurrentUserModel {
        val userName = mainRepository.getUserNameById(currentUserId)
        val walletName = mainRepository.getWalletNameById(currentWalletId)
        return CurrentUserModel(
            userName = userName,
            walletName = walletName
        )
    }

    override suspend fun formSpendingToday(): String {
        val spendingModelsToday = mainRepository.getAllSpendingToday(
            today,
            currentWalletId
        )
        val amountSpendingToday = spendingModelsToday.sumOf { model -> model.amount }
        return if (amountSpendingToday == 0.0) {
            AMOUNT_ZERO
        } else {
            amountSpendingToday.toString()
        }
    }

    private companion object {

        const val USER_ERROR_MESSAGE = "Current user cannot be null"
        const val AMOUNT_ZERO = "\"0.00\""
    }
}
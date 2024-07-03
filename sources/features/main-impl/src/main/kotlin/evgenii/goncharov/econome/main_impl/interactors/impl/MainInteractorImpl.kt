package evgenii.goncharov.econome.main_impl.interactors.impl

import evgenii.goncharov.econome.current_user.repositories.CurrentUserRepository
import evgenii.goncharov.econome.current_user.repositories.CurrentWalletRepository
import evgenii.goncharov.econome.main_impl.interactors.MainInteractor
import evgenii.goncharov.econome.main_impl.models.CurrentUserModel
import evgenii.goncharov.econome.main_impl.repositories.MainRepository
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

internal class MainInteractorImpl @Inject constructor(
    private val currentUserRepository: CurrentUserRepository,
    private val currentWalletRepository: CurrentWalletRepository,
    private val mainRepository: MainRepository,
    private val appLocale: Locale
) : MainInteractor {

    private val today = Calendar.getInstance().time

    override fun checkParameters() {
        currentUserRepository.currentUserId
        currentWalletRepository.currentWalletId
    }

    override suspend fun formCurrentUser(): CurrentUserModel {
        val userName = mainRepository.getUserNameById(currentUserRepository.currentUserId)
        val walletName = mainRepository.getWalletNameById(currentWalletRepository.currentWalletId)
        return CurrentUserModel(
            userName = userName,
            walletName = walletName
        )
    }

    override suspend fun formSpendingToday(): String {
        val spendingModelsToday = mainRepository.getAllSpendingToday(
            today,
            currentWalletRepository.currentWalletId
        )
        val amountSpendingToday = spendingModelsToday.sumOf { model -> model.amount }
        return if (amountSpendingToday == 0.0) {
            AMOUNT_ZERO
        } else {
            String.format(appLocale, AMOUNT_FORMAT_PATTERN, amountSpendingToday)
        }
    }

    override suspend fun getCurrentCurrency(): String {
        return ""
    }

    private companion object {

        const val AMOUNT_ZERO = "0.00"
        const val AMOUNT_FORMAT_PATTERN = "%.2f"
    }
}
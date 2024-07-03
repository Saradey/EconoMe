package evgenii.goncharov.econome.main_impl.repositories

import evgenii.goncharov.econome.main_impl.models.SpendingModel
import java.util.Date

internal interface MainRepository {

    suspend fun getUserNameById(currentUserId: String): String

    suspend fun getWalletNameById(currentWalletId: Long): String

    suspend fun getAllSpendingToday(
        today: Date,
        currentWalletId: Long
    ): List<SpendingModel>

    suspend fun getCurrentCurrency(currentWalletId: Long): String
}
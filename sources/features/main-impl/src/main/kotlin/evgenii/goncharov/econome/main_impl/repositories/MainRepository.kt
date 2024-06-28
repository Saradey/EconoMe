package evgenii.goncharov.econome.main_impl.repositories

import evgenii.goncharov.econome.main_impl.models.SpendingModel

internal interface MainRepository {

    suspend fun getUserNameById(currentUserId: String): String

    suspend fun getWalletNameById(currentWalletId: Long): String

    suspend fun getAllSpendingToday(): List<SpendingModel>
}
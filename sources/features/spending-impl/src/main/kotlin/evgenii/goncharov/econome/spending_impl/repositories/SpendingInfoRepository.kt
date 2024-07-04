package evgenii.goncharov.econome.spending_impl.repositories

import evgenii.goncharov.econome.spending_impl.models.SpendingInfoModel

internal interface SpendingInfoRepository {

    suspend fun getSpendingInfoById(spendingId: Long) : SpendingInfoModel

    suspend fun getCurrentCurrency(currentWalletId: Long): String
}
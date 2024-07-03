package evgenii.goncharov.econome.main_impl.repositories.impl

import evgenii.goncharov.econome.core_database_api.data.stores.SpendingDataStore
import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore
import evgenii.goncharov.econome.core_database_api.data.stores.WalletDataStore
import evgenii.goncharov.econome.main_impl.models.SpendingModel
import evgenii.goncharov.econome.main_impl.models.mappers.MapperSpendingDtoToSpendingModel
import evgenii.goncharov.econome.main_impl.repositories.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Date
import javax.inject.Inject

internal class MainRepositoryImpl @Inject constructor(
    private val userDataStore: UserDataStore,
    private val walletDataStore: WalletDataStore,
    private val spendingDataStore: SpendingDataStore,
    private val mapper: MapperSpendingDtoToSpendingModel
) : MainRepository {

    override suspend fun getUserNameById(currentUserId: String): String =
        withContext(Dispatchers.IO) {
            val userDto = userDataStore.getUserById(currentUserId)
            userDto.userName
        }

    override suspend fun getWalletNameById(currentWalletId: Long): String =
        withContext(Dispatchers.IO) {
            val walletDto = walletDataStore.getWalletById(currentWalletId)
            walletDto.walletName
        }

    override suspend fun getAllSpendingToday(
        today: Date,
        currentWalletId: Long
    ): List<SpendingModel> = withContext(Dispatchers.IO) {
        val spendingToday = spendingDataStore.spendingToDate(
            today.time,
            currentWalletId
        )
        mapper.map(spendingToday)
    }

    override suspend fun getCurrentCurrency(currentWalletId: Long): String =
        withContext(Dispatchers.IO) {
            val walletDto = walletDataStore.getWalletById(currentWalletId)
            walletDto.currencyCode
        }
}
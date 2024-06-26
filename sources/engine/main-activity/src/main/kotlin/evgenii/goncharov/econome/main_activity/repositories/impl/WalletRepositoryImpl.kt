package evgenii.goncharov.econome.main_activity.repositories.impl

import evgenii.goncharov.econome.core_database_api.data.stores.CurrentWalletDataStore
import evgenii.goncharov.econome.core_database_api.data.stores.WalletDataStore
import evgenii.goncharov.econome.core_database_api.dto.WalletDto
import evgenii.goncharov.econome.main_activity.repositories.WalletRepository
import javax.inject.Inject

internal class WalletRepositoryImpl @Inject constructor(
    private val walletDataStore: WalletDataStore,
    private val currentWalletDataStore: CurrentWalletDataStore
) : WalletRepository {

    override suspend fun getAllWallets(): List<WalletDto> {
        return walletDataStore.getAllWallet()
    }

    override suspend fun getCurrentWalletId(): Long {
        return currentWalletDataStore.getCurrentWalletId()
    }
}
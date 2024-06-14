package evgenii.goncharov.econome.main_activity.repositories.impl

import evgenii.goncharov.econome.core_database_api.data.stores.WalletDataStore
import evgenii.goncharov.econome.core_database_api.dto.WalletDto
import evgenii.goncharov.econome.main_activity.repositories.WalletRepository
import javax.inject.Inject

internal class WalletRepositoryImpl @Inject constructor(
    private val walletDataStore: WalletDataStore
) : WalletRepository {

    override suspend fun getAllWallets(): List<WalletDto> {
        return walletDataStore.getAllWallet()
    }
}
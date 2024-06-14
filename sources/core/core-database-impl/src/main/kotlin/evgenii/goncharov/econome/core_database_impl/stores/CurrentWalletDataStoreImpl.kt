package evgenii.goncharov.econome.core_database_impl.stores

import evgenii.goncharov.econome.core_database_api.data.stores.CurrentWalletDataStore
import evgenii.goncharov.econome.core_database_api.dto.CurrentWalletDto
import evgenii.goncharov.econome.core_database_impl.dao.CurrentWalletDao
import evgenii.goncharov.econome.core_database_impl.entities.CurrentWalletEntity
import javax.inject.Inject

internal class CurrentWalletDataStoreImpl @Inject constructor(
    private val currentWalletDao: CurrentWalletDao
) : CurrentWalletDataStore {

    override suspend fun saveCurrentWallet(dto: CurrentWalletDto) {
        currentWalletDao.saveWallet(
            CurrentWalletEntity(
                currentWalletId = dto.currentWalletId
            )
        )
    }
}
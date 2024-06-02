package evgenii.goncharov.econome.core_database_impl.stores

import evgenii.goncharov.econome.core_database_api.data.stores.WalletDataStore
import evgenii.goncharov.econome.core_database_api.dto.WalletDto
import evgenii.goncharov.econome.core_database_impl.dao.WalletDao
import evgenii.goncharov.econome.core_database_impl.mappers.WalletMapper
import javax.inject.Inject

internal class WalletDataStoreImpl @Inject constructor(
    private val walletDao: WalletDao,
    private val walletMapper: WalletMapper
) : WalletDataStore {

    override suspend fun saveNewWallet(dto: WalletDto) {
        walletDao.saveWallet(walletMapper.walletDtoToWalletEntity(dto))
    }
}
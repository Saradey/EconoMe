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

    override suspend fun getAllWallet(): List<WalletDto> {
        return walletDao.getWallets().map { entity ->
            walletMapper.walletEntityToWalletDto(entity)
        }
    }

    override suspend fun getLastWalletSequenceNumber(): Int {
        val wallet = walletDao.getWalletWithMaxSequenceNumber()
        return wallet?.sequenceNumber ?: 0
    }

    override suspend fun getWalletById(walletId: Long): WalletDto {
        val walletDto = walletMapper.walletEntityToWalletDto(
            walletDao.getWalletById(walletId)
        )
        return walletDto
    }
}
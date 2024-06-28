package evgenii.goncharov.econome.core_database_api.data.stores

import androidx.annotation.WorkerThread
import evgenii.goncharov.econome.core_database_api.dto.WalletDto

public interface WalletDataStore {

    @WorkerThread
    public suspend fun saveNewWallet(dto: WalletDto)

    @WorkerThread
    public suspend fun getAllWallet(): List<WalletDto>

    @WorkerThread
    public suspend fun getLastWalletSequenceNumber(): Int

    @WorkerThread
    public suspend fun getWalletById(walletId: Long): WalletDto
}
package evgenii.goncharov.econome.core_database_api.data.stores

import androidx.annotation.WorkerThread
import evgenii.goncharov.econome.core_database_api.dto.CurrentWalletDto

public interface CurrentWalletDataStore {

    @WorkerThread
    public suspend fun saveCurrentWallet(dto: CurrentWalletDto)
}
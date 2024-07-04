package evgenii.goncharov.econome.core_database_api.data.stores

import androidx.annotation.WorkerThread
import evgenii.goncharov.econome.core_database_api.dto.SpendingDto

public interface SpendingDataStore {

    @WorkerThread
    public suspend fun saveSpending(dto: SpendingDto)

    @WorkerThread
    public suspend fun spendingToDate(date: Long, currentWalletId: Long): List<SpendingDto>

    @WorkerThread
    public suspend fun getSpending(spendingId: Long): SpendingDto
}
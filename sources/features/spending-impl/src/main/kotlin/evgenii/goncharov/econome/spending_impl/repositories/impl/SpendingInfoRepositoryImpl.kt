package evgenii.goncharov.econome.spending_impl.repositories.impl

import evgenii.goncharov.econome.core_database_api.data.stores.SpendingDataStore
import evgenii.goncharov.econome.spending_impl.models.SpendingInfoModel
import evgenii.goncharov.econome.spending_impl.models.mappers.MapperSpendingDtoToSpendingInfoModel
import evgenii.goncharov.econome.spending_impl.repositories.SpendingInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class SpendingInfoRepositoryImpl @Inject constructor(
    private val spendingDataStore: SpendingDataStore,
    private val mapper: MapperSpendingDtoToSpendingInfoModel
) : SpendingInfoRepository {

    override suspend fun getSpendingInfoById(spendingId: Long): SpendingInfoModel =
        withContext(Dispatchers.IO) {
            val dto = spendingDataStore.getSpending(spendingId)
            mapper.map(dto)
        }
}
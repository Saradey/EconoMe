package evgenii.goncharov.econome.core_database_impl.stores

import evgenii.goncharov.econome.core_database_api.data.stores.SpendingDataStore
import evgenii.goncharov.econome.core_database_api.dto.SpendingDto
import evgenii.goncharov.econome.core_database_impl.dao.SpendingDao
import evgenii.goncharov.econome.core_database_impl.mappers.SpendingMapper
import javax.inject.Inject

internal class SpendingDataStoreImpl @Inject constructor(
    private val spendingDao: SpendingDao,
    private val spendingMapper: SpendingMapper
) : SpendingDataStore {

    override suspend fun saveSpending(dto: SpendingDto) {
        spendingDao.saveSpending(
            spendingMapper.mapSpendingDtoToSpendingEntity(dto)
        )
    }

    override suspend fun spendingToDate(date: Long): List<SpendingDto> {
        return spendingMapper.mapSpendingEntityToSpendingDto(
            spendingDao.getSpendingsByDate(date)
        )
    }
}
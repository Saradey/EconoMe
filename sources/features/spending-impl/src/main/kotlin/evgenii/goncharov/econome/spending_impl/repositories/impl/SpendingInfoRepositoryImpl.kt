package evgenii.goncharov.econome.spending_impl.repositories.impl

import evgenii.goncharov.econome.core_database_api.data.stores.SpendingDataStore
import evgenii.goncharov.econome.spending_impl.models.SpendingInfoModel
import evgenii.goncharov.econome.spending_impl.repositories.SpendingInfoRepository
import javax.inject.Inject

internal class SpendingInfoRepositoryImpl @Inject constructor(
    private val spendingDataStore: SpendingDataStore
) : SpendingInfoRepository {

    override fun getSpendingInfoById(): SpendingInfoModel {

    }
}
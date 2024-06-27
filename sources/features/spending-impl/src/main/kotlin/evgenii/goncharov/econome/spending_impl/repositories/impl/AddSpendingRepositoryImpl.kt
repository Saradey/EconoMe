package evgenii.goncharov.econome.spending_impl.repositories.impl

import evgenii.goncharov.econome.core_database_api.data.stores.SpendingDataStore
import evgenii.goncharov.econome.spending_impl.models.SpendingModel
import evgenii.goncharov.econome.spending_impl.repositories.AddSpendingRepository
import javax.inject.Inject

internal class AddSpendingRepositoryImpl @Inject constructor(
    private val spendingDataStore: SpendingDataStore
) : AddSpendingRepository {

    override val selectedCategories: MutableList<Long> = mutableListOf()

    override suspend fun createSpending(spendingModel: SpendingModel) {

    }
}
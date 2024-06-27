package evgenii.goncharov.econome.spending_impl.repositories

import evgenii.goncharov.econome.spending_impl.models.SpendingModel

internal interface AddSpendingRepository {

    val selectedCategories: MutableList<Long>

    suspend fun createSpending(spendingModel: SpendingModel)
}
package evgenii.goncharov.econome.spending_impl.interactors

import evgenii.goncharov.econome.spending_impl.models.SpendingCategory
import evgenii.goncharov.econome.spending_impl.models.SpendingModel

internal interface AddSpendingInteractor {

    fun validateMainButtonEnabled(
        inputSpending: String,
        spendingCategories: List<SpendingCategory>
    ): Boolean

    fun chooseSpendingCategory(spendingCategoryId: Long)

    fun calculateCategoriesState(spendingCategories: List<SpendingCategory>): List<SpendingCategory>

    suspend fun createSpending(spendingModel: SpendingModel)
}
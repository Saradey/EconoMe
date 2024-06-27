package evgenii.goncharov.econome.spending_impl.interactors

import evgenii.goncharov.econome.spending_impl.models.SpendingCategory

internal interface AddSpendingInteractor {

    fun validateMainButtonEnabled(
        inputSpending: String,
        spendingCategories: List<SpendingCategory>
    ): Boolean

    fun chooseSpendingCategory(spendingCategoryId: Long)
}
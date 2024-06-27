package evgenii.goncharov.econome.spending_impl.interactors.impl

import evgenii.goncharov.econome.spending_impl.interactors.AddSpendingInteractor
import evgenii.goncharov.econome.spending_impl.models.SpendingCategory
import javax.inject.Inject

internal class AddSpendingInteractorImpl @Inject constructor() : AddSpendingInteractor {

    override fun validateMainButtonEnabled(
        inputSpending: String,
        spendingCategories: List<SpendingCategory>
    ): Boolean {
        return inputSpending.isNotEmpty() && spendingCategories.any { category ->
            category.isSelected
        }
    }
}
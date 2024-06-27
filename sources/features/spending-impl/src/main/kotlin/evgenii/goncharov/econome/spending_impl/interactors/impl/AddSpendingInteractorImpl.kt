package evgenii.goncharov.econome.spending_impl.interactors.impl

import evgenii.goncharov.econome.spending_impl.interactors.AddSpendingInteractor
import evgenii.goncharov.econome.spending_impl.models.SpendingCategory
import evgenii.goncharov.econome.spending_impl.repositories.AddSpendingRepository
import javax.inject.Inject

internal class AddSpendingInteractorImpl @Inject constructor(
    private val addSpendingRepository: AddSpendingRepository
) : AddSpendingInteractor {

    override fun validateMainButtonEnabled(
        inputSpending: String,
        spendingCategories: List<SpendingCategory>
    ): Boolean {
        return inputSpending.isNotEmpty() && spendingCategories.any { category ->
            category.isSelected
        }
    }

    override fun chooseSpendingCategory(spendingCategoryId: Long) {
        addSpendingRepository.selectedCategories.add(spendingCategoryId)
    }
}
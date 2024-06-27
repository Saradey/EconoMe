package evgenii.goncharov.econome.spending_impl.interactors.impl

import evgenii.goncharov.econome.spending_impl.interactors.AddSpendingInteractor
import evgenii.goncharov.econome.spending_impl.models.SpendingCategory
import evgenii.goncharov.econome.spending_impl.models.SpendingModel
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

    override fun chooseSpendingCategory(
        spendingCategoryId: Long,
    ) {
        if (addSpendingRepository.selectedCategories.contains(spendingCategoryId)) {
            addSpendingRepository.selectedCategories.remove(spendingCategoryId)
        } else {
            if (addSpendingRepository.selectedCategories.size > 2) {
                addSpendingRepository.selectedCategories.removeFirst()
            }
            addSpendingRepository.selectedCategories.add(spendingCategoryId)
        }
    }

    override fun calculateCategoriesState(
        spendingCategories: List<SpendingCategory>
    ): List<SpendingCategory> {
        return spendingCategories.map { category ->
            category.copy(
                isSelected = addSpendingRepository.selectedCategories.contains(category.id)
            )
        }
    }

    override fun createSpending(spendingModel: SpendingModel) {
        addSpendingRepository.createSpending(spendingModel)
    }
}
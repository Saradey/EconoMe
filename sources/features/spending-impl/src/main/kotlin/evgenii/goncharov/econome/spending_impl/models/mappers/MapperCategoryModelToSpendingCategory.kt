package evgenii.goncharov.econome.spending_impl.models.mappers

import evgenii.goncharov.econome.category.models.CategoryModel
import evgenii.goncharov.econome.spending_impl.models.SpendingCategory
import javax.inject.Inject

internal class MapperCategoryModelToSpendingCategory @Inject constructor() {

    fun mapCategoryModelToSpendingCategory(models: List<CategoryModel>): List<SpendingCategory> {
        return models.map { model ->
            SpendingCategory(
                id = model.id,
                title = model.title,
                isSelected = false
            )
        }
    }
}
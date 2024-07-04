package evgenii.goncharov.econome.main_impl.models.mappers

import evgenii.goncharov.econome.category.interactors.DefaultCategoryInteractor
import evgenii.goncharov.econome.category.models.CategoryModel
import evgenii.goncharov.econome.core_database_api.dto.SpendingDto
import evgenii.goncharov.econome.main_impl.models.SpendingItemModel
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

internal class MapperSpendingDtoToSpendingItemModel @Inject constructor(
    appLocale: Locale,
    private val defaultCategoryInteractor: DefaultCategoryInteractor
) {

    private val timeHourAndMinuteDateFormatter = SimpleDateFormat(TIME_FORMAT, appLocale)

    fun map(dto: List<SpendingDto>): List<SpendingItemModel> {
        return dto.sortedBy { spendingDto ->
            spendingDto.createAt.time
        } .mapIndexed { index, spendingDto ->
            val categories = defaultCategoryInteractor.provideCategoriesByIds(
                spendingDto.categoriesId
            )
            SpendingItemModel(
                number = (index + 1).toString(),
                amount = spendingDto.amount.toString(),
                comment = spendingDto.comment.ifEmpty { EMPTY_COMMENT },
                spendingCategoryTitle = mapCategoriesToTitles(categories),
                spendingTime = timeHourAndMinuteDateFormatter.format(spendingDto.createAt)
            )
        }
    }

    private fun mapCategoriesToTitles(categories: List<CategoryModel>): List<String> {
        return categories.map { model ->
            model.title
        }
    }

    private companion object {

        const val TIME_FORMAT = "HH-mm"
        const val EMPTY_COMMENT = "-"
    }
}
package evgenii.goncharov.econome.spending_impl.models.mappers

import evgenii.goncharov.econome.category.interactors.DefaultCategoryInteractor
import evgenii.goncharov.econome.category.models.CategoryModel
import evgenii.goncharov.econome.common.consts.AMOUNT_FORMAT_PATTERN
import evgenii.goncharov.econome.core_database_api.dto.SpendingDto
import evgenii.goncharov.econome.spending_impl.models.SpendingInfoModel
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

internal class MapperSpendingDtoToSpendingInfoModel @Inject constructor(
    private val appLocale: Locale,
    private val defaultCategoryInteractor: DefaultCategoryInteractor
) {

    private val formatter = SimpleDateFormat(TIME_FORMAT, appLocale)

    fun map(dto: SpendingDto): SpendingInfoModel {
        val categories = defaultCategoryInteractor.provideCategoriesByIds(dto.categoriesId)
        return SpendingInfoModel(
            amount = String.format(appLocale, AMOUNT_FORMAT_PATTERN, dto.amount),
            comment = dto.comment.ifEmpty { EMPTY_COMMENT },
            categories = mapCategoriesToTitles(categories),
            spendingTime = formatter.format(dto.createAt)
        )
    }

    private fun mapCategoriesToTitles(categories: List<CategoryModel>): List<String> {
        return categories.map { model ->
            model.title
        }
    }

    private companion object {

        const val TIME_FORMAT = "yyyy 'г.' dd MMM HH-mm"
        const val EMPTY_COMMENT = "-"
    }
}
package evgenii.goncharov.econome.category.models.mappers

import evgenii.goncharov.econome.category.models.CategoryModel
import evgenii.goncharov.econome.category.models.DefaultCategoryDto
import java.util.Locale
import javax.inject.Inject

internal class MapperDefaultCategoryDtoToDefaultCategoryDto @Inject constructor(
    private val locale: Locale
) {

    fun mapDefaultCategoryDtoToCategoryModel(
        dto: DefaultCategoryDto
    ): CategoryModel {
        return CategoryModel(
            id = dto.id,
            title = mapTitle(dto)
        )
    }

    private fun mapTitle(dto: DefaultCategoryDto): String {
        return when (locale.language) {
            RU_LOCALE -> dto.titleRu
            else -> dto.titleEn
        }
    }

    private companion object {

        const val RU_LOCALE = "ru"
    }
}
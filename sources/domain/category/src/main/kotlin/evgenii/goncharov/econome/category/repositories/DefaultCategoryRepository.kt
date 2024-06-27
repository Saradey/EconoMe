package evgenii.goncharov.econome.category.repositories

import evgenii.goncharov.econome.category.models.DefaultCategoryDto

internal interface DefaultCategoryRepository {

    fun getCategorise() : List<DefaultCategoryDto>
}
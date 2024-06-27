package evgenii.goncharov.econome.category.repositories.impl

import evgenii.goncharov.econome.category.R
import evgenii.goncharov.econome.category.models.DefaultCategoryDto
import evgenii.goncharov.econome.category.models.DefaultCategoryListDto
import evgenii.goncharov.econome.category.repositories.DefaultCategoryRepository
import evgenii.goncharov.econome.common.readRawCurrency
import evgenii.goncharov.econome.common_provider.managers.ResourceManager
import kotlinx.serialization.json.Json
import javax.inject.Inject

internal class DefaultCategoryRepositoryImpl @Inject constructor(
    private val resourceManager: ResourceManager,
    private val json: Json
): DefaultCategoryRepository {

    private var cacheCategoryList: DefaultCategoryListDto? = null

    override fun getCategorise(): List<DefaultCategoryDto> {
        val categories = cacheCategoryList?.defaultCategories ?: let {
            val rawCategories = resourceManager.getRawFile(R.raw.default_category_list)
            val rawJsonCategories = readRawCurrency(rawCategories)
            val categoriesDecoded = json.decodeFromString<DefaultCategoryListDto>(rawJsonCategories)
            cacheCategoryList = categoriesDecoded
            categoriesDecoded.defaultCategories
        }
        return categories
    }
}
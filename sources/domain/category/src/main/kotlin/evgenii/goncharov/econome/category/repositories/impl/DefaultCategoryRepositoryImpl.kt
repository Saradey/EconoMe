package evgenii.goncharov.econome.category.repositories.impl

import evgenii.goncharov.econome.category.models.DefaultCategoryListDto
import evgenii.goncharov.econome.category.repositories.DefaultCategoryRepository
import evgenii.goncharov.econome.common_provider.managers.ResourceManager
import kotlinx.serialization.json.Json
import javax.inject.Inject

internal class DefaultCategoryRepositoryImpl @Inject constructor(
    private val resourceManager: ResourceManager,
    private val json: Json
): DefaultCategoryRepository {

    private var cacheCategoryList: DefaultCategoryListDto? = null

}
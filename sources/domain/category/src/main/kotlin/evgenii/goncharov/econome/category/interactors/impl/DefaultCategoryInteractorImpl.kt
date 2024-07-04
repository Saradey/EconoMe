package evgenii.goncharov.econome.category.interactors.impl

import evgenii.goncharov.econome.category.interactors.DefaultCategoryInteractor
import evgenii.goncharov.econome.category.models.CategoryModel
import evgenii.goncharov.econome.category.models.mappers.MapperDefaultCategoryDtoToDefaultCategoryDto
import evgenii.goncharov.econome.category.repositories.DefaultCategoryRepository
import evgenii.goncharov.econome.core_database_api.data.stores.CategorySpendingDataStore
import javax.inject.Inject

internal class DefaultCategoryInteractorImpl @Inject constructor(
    private val defaultCategoryRepository: DefaultCategoryRepository,
    private val mapper: MapperDefaultCategoryDtoToDefaultCategoryDto,
    private val categorySpendingDataStore: CategorySpendingDataStore
) : DefaultCategoryInteractor {

    override fun provideCategories(): List<CategoryModel> {
        // TODO матчить дефолтные категории с категориями которые создал пользователь
        return defaultCategoryRepository.getCategorise()
            .map(mapper::mapDefaultCategoryDtoToCategoryModel)
    }

    override fun provideCategoriesByIds(categoriesId: List<Long>): List<CategoryModel> {
        // TODO матчить дефолтные категории с категориями которые создал пользователь
        return defaultCategoryRepository.getCategorise().filter { category ->
            categoriesId.any { id -> id == category.id }
        }.map(mapper::mapDefaultCategoryDtoToCategoryModel)
    }
}
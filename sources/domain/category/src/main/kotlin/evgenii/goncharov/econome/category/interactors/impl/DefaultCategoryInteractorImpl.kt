package evgenii.goncharov.econome.category.interactors.impl

import evgenii.goncharov.econome.category.interactors.DefaultCategoryInteractor
import evgenii.goncharov.econome.category.models.CategoryModel
import evgenii.goncharov.econome.category.models.mappers.MapperDefaultCategoryDtoToDefaultCategoryDto
import evgenii.goncharov.econome.category.repositories.DefaultCategoryRepository
import javax.inject.Inject

internal class DefaultCategoryInteractorImpl @Inject constructor(
    private val defaultCategoryRepository: DefaultCategoryRepository,
    private val mapper: MapperDefaultCategoryDtoToDefaultCategoryDto
) : DefaultCategoryInteractor {

    override fun provideCategories(): List<CategoryModel> {
        return defaultCategoryRepository.getCategorise().map { dto ->
            mapper.mapDefaultCategoryDtoToCategoryModel(dto)
        }
    }
}
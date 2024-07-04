package evgenii.goncharov.econome.category.interactors

import evgenii.goncharov.econome.category.models.CategoryModel

public interface DefaultCategoryInteractor {

    public fun provideCategories(): List<CategoryModel>

    public fun provideCategoriesByIds(categoriesId: List<Long>) : List<CategoryModel>
}
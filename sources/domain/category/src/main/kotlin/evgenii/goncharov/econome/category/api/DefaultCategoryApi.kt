package evgenii.goncharov.econome.category.api

import evgenii.goncharov.econome.category.interactors.DefaultCategoryInteractor

public interface DefaultCategoryApi {

    public fun provideCategoryInteractor() : DefaultCategoryInteractor
}
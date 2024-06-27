package evgenii.goncharov.econome.category.api

import evgenii.goncharov.econome.category.interactors.CategoryInteractor

public interface CategoryApi {

    public fun provideCategoryInteractor() : CategoryInteractor
}
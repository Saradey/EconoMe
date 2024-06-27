package evgenii.goncharov.econome.category.interactors.impl

import evgenii.goncharov.econome.category.interactors.DefaultCategoryInteractor
import evgenii.goncharov.econome.category.repositories.DefaultCategoryRepository
import javax.inject.Inject

internal class DefaultCategoryInteractorImpl @Inject constructor(
    private val defaultCategoryRepository: DefaultCategoryRepository
): DefaultCategoryInteractor {
}
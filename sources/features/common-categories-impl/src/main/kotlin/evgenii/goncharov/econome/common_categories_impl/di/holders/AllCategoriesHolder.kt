package evgenii.goncharov.econome.common_categories_impl.di.holders

import evgenii.goncharov.econome.common_categories_api.di.AllCategoriesApi
import evgenii.goncharov.econome.common_categories_impl.di.components.DaggerAllCategoriesComponent
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import javax.inject.Inject

public class AllCategoriesHolder  @Inject constructor(container: FeatureContainer) :
    FeatureHolder<AllCategoriesApi>(container) {

    override fun buildComponent(): AllCategoriesApi {
        return DaggerAllCategoriesComponent.factory().create()
    }
}
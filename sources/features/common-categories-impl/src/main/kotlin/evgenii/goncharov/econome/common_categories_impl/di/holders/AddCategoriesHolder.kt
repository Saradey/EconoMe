package evgenii.goncharov.econome.common_categories_impl.di.holders

import evgenii.goncharov.econome.common_categories_api.di.AddCategoriesApi
import evgenii.goncharov.econome.common_categories_impl.di.components.DaggerAddCategoriesComponent
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import javax.inject.Inject

public class AddCategoriesHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<AddCategoriesApi>(container) {

    override fun buildComponent(): AddCategoriesApi {
        return DaggerAddCategoriesComponent.factory().create()
    }
}
package evgenii.goncharov.econome.product_categories_impl.di.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.product_categories_api.di.AddSubProductApi
import evgenii.goncharov.econome.product_categories_impl.di.components.DaggerAddSubProductComponent
import javax.inject.Inject

public class AddSubProductHolder  @Inject constructor(container: FeatureContainer) :
    FeatureHolder<AddSubProductApi>(container) {

    override fun buildComponent(): AddSubProductApi {
        return DaggerAddSubProductComponent.factory().create()
    }
}
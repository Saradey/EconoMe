package evgenii.goncharov.econome.product_categories_impl.di.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.product_categories_api.di.AddProductApi
import evgenii.goncharov.econome.product_categories_impl.di.components.DaggerAddProductComponent
import javax.inject.Inject

public class AddProductHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<AddProductApi>(container) {

    override fun buildComponent(): AddProductApi {
        return DaggerAddProductComponent.factory().create()
    }
}
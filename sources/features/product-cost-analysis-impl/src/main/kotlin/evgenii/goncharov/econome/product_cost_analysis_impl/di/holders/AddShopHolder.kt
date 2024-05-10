package evgenii.goncharov.econome.product_cost_analysis_impl.di.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.product_cost_analysis_api.di.AddShopApi
import evgenii.goncharov.econome.product_cost_analysis_impl.di.components.DaggerAddShopComponent
import javax.inject.Inject

public class AddShopHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<AddShopApi>(container) {

    override fun buildComponent(): AddShopApi {
        return DaggerAddShopComponent.factory().create()
    }
}
package evgenii.goncharov.econome.product_cost_analysis_impl.di.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.product_cost_analysis_api.di.AppShopApi
import evgenii.goncharov.econome.product_cost_analysis_impl.di.components.DaggerAppShopComponent
import javax.inject.Inject

public class AppShopHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<AppShopApi>(container) {

    override fun buildComponent(): AppShopApi {
        return DaggerAppShopComponent.factory().create()
    }
}
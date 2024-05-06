package evgenii.goncharov.econome.product_cost_analysis_impl.di.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.product_cost_analysis_api.di.ListShopsApi
import evgenii.goncharov.econome.product_cost_analysis_impl.di.components.DaggerListShopsComponent
import javax.inject.Inject

public class ListShopsHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<ListShopsApi>(container) {

    override fun buildComponent():  ListShopsApi {
        return DaggerListShopsComponent.factory().create()
    }
}
package evgenii.goncharov.econome.product_cost_analysis_impl.di.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.product_cost_analysis_api.di.AddCostGoodsApi
import evgenii.goncharov.econome.product_cost_analysis_impl.di.components.DaggerAddCostGoodsComponent
import javax.inject.Inject

public class AddCostGoodsHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<AddCostGoodsApi>(container) {

    override fun buildComponent(): AddCostGoodsApi {
        return DaggerAddCostGoodsComponent.factory().create()
    }
}
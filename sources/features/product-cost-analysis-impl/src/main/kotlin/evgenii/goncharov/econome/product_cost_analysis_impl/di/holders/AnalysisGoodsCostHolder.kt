package evgenii.goncharov.econome.product_cost_analysis_impl.di.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.product_cost_analysis_api.di.AnalysisGoodsCostApi
import evgenii.goncharov.econome.product_cost_analysis_impl.di.components.DaggerAnalysisGoodsCostComponent
import javax.inject.Inject

public class AnalysisGoodsCostHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<AnalysisGoodsCostApi>(container) {

    override fun buildComponent(): AnalysisGoodsCostApi {
        return DaggerAnalysisGoodsCostComponent.factory().create()
    }
}
package evgenii.goncharov.econome.product_cost_analysis_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.product_cost_analysis_impl.di.contracts.AnalysisGoodsCostInternal
import evgenii.goncharov.econome.product_cost_analysis_impl.di.modules.AnalysisGoodsCostBindModule

@FeatureScope
@Component(
    modules = [AnalysisGoodsCostBindModule::class]
)
internal interface AnalysisGoodsCostComponent : AnalysisGoodsCostInternal {

    @Component.Factory
    interface Factory {

        fun create(): AnalysisGoodsCostComponent
    }
}
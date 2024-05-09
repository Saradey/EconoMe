package evgenii.goncharov.econome.product_cost_analysis_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.product_cost_analysis_impl.di.contracts.AddCostGoodsInternal
import evgenii.goncharov.econome.product_cost_analysis_impl.di.modules.AddCostGoodsBindsModule

@FeatureScope
@Component(modules = [AddCostGoodsBindsModule::class])
internal interface AddCostGoodsComponent : AddCostGoodsInternal {

    @Component.Factory
    interface Factory {
        fun create(): AddCostGoodsComponent
    }
}
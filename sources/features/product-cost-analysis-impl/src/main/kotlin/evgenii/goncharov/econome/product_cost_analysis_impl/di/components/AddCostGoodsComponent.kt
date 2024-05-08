package evgenii.goncharov.econome.product_cost_analysis_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.product_cost_analysis_impl.di.modules.AddCostGoodsViewModelBindsModule

@FeatureScope
@Component(modules = [AddCostGoodsViewModelBindsModule::class])
internal interface AddCostGoodsComponent {

    @Component.Factory
    interface Factory {
        fun create(): AddCostGoodsComponent
    }
}
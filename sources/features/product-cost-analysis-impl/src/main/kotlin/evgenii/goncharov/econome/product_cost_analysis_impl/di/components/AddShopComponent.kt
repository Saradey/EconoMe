package evgenii.goncharov.econome.product_cost_analysis_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.product_cost_analysis_impl.di.contracts.AddShopInternal
import evgenii.goncharov.econome.product_cost_analysis_impl.di.modules.AddShopBindModule

@FeatureScope
@Component(
    modules = [AddShopBindModule::class]
)
internal interface AddShopComponent : AddShopInternal {

    @Component.Factory
    interface Factory {

        fun create(): AddShopComponent
    }
}
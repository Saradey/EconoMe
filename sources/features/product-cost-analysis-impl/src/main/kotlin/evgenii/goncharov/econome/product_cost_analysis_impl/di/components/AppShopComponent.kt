package evgenii.goncharov.econome.product_cost_analysis_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.product_cost_analysis_impl.di.contracts.AppShopInternal
import evgenii.goncharov.econome.product_cost_analysis_impl.di.modules.AppShopBindModule

@FeatureScope
@Component(
    modules = [AppShopBindModule::class]
)
internal interface AppShopComponent : AppShopInternal {

    @Component.Factory
    interface Factory {

        fun create(): AppShopComponent
    }
}
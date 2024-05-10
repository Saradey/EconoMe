package evgenii.goncharov.econome.product_cost_analysis_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.product_cost_analysis_api.navigation.ProductCostAnalysisLauncher
import evgenii.goncharov.econome.product_cost_analysis_impl.di.contracts.ListShopsInternal
import evgenii.goncharov.econome.product_cost_analysis_impl.di.modules.ListShopsBindModule

@FeatureScope
@Component(
    modules = [
        ListShopsBindModule::class
    ]
)
internal interface ListShopsComponent : ListShopsInternal {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance productCostAnalysisLauncher: ProductCostAnalysisLauncher
        ): ListShopsComponent
    }
}
package evgenii.goncharov.econome.product_cost_analysis_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.product_cost_analysis_impl.di.contracts.ListShopsInternal
import evgenii.goncharov.econome.product_cost_analysis_impl.di.modules.ListShopsViewModelBindsModule

@FeatureScope
@Component(
    modules = [
        ListShopsViewModelBindsModule::class
    ]
)
internal interface ListShopsComponent : ListShopsInternal {

    @Component.Factory
    interface Factory {

        fun create(): ListShopsComponent
    }
}
package evgenii.goncharov.econome.spending_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.spending_impl.di.contracts.SpendingInfoInternal
import evgenii.goncharov.econome.spending_impl.di.modules.SpendingInfoBindModule

@FeatureScope
@Component(
    modules = [SpendingInfoBindModule::class]
)
internal interface SpendingInfoComponent : SpendingInfoInternal {

    @Component.Factory
    interface Factory {
        fun create(): SpendingInfoComponent
    }
}
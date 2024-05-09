package evgenii.goncharov.econome.main_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_impl.di.contracts.SpendingLimitInternal
import evgenii.goncharov.econome.main_impl.di.modules.SpendingLimitBindModule

@FeatureScope
@Component(
    modules = [SpendingLimitBindModule::class]
)
internal interface SpendingLimitComponent : SpendingLimitInternal {

    @Component.Factory
    interface Factory {

        fun create(): SpendingLimitComponent
    }
}
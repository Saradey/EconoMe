package evgenii.goncharov.econome.spending_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.spending_impl.di.contracts.AddSpendingInternal
import evgenii.goncharov.econome.spending_impl.di.modules.AddSpendingViewModelBindModule

@FeatureScope
@Component(
    modules = [AddSpendingViewModelBindModule::class]
)
internal interface AddSpendingComponent : AddSpendingInternal {

    @Component.Factory
    interface Factory {

        fun create(): AddSpendingComponent
    }
}
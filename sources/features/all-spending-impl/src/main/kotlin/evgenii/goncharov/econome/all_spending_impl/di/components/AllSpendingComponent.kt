package evgenii.goncharov.econome.all_spending_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.all_spending_impl.di.contracts.AllSpendingInternal
import evgenii.goncharov.econome.all_spending_impl.di.modules.AllSpendingViewModelBindsModule
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope

@FeatureScope
@Component(
    modules = [
        AllSpendingViewModelBindsModule::class
    ]
)
internal interface AllSpendingComponent : AllSpendingInternal {

    @Component.Factory
    interface Factory {

        fun create(): AllSpendingComponent
    }
}
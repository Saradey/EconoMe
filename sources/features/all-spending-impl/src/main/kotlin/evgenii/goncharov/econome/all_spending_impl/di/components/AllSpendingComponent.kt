package evgenii.goncharov.econome.all_spending_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.all_spending_impl.di.contracts.AllSpendingInternal
import evgenii.goncharov.econome.all_spending_impl.di.modules.AllSpendingBindModule
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.spending_api.navigation.SpendingLauncher

@FeatureScope
@Component(
    modules = [
        AllSpendingBindModule::class
    ]
)
internal interface AllSpendingComponent : AllSpendingInternal {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance spendingLauncher: SpendingLauncher
        ): AllSpendingComponent
    }
}
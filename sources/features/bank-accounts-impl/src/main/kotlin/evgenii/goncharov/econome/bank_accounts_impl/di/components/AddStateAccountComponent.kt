package evgenii.goncharov.econome.bank_accounts_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.bank_accounts_impl.di.contracts.AddStateAccountInternal
import evgenii.goncharov.econome.bank_accounts_impl.di.modules.AddStateAccountBindModule
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope

@FeatureScope
@Component(
    modules = [
        AddStateAccountBindModule::class
    ]
)
internal interface AddStateAccountComponent : AddStateAccountInternal {

    @Component.Factory
    interface Factory {

        fun create(): AddStateAccountInternal
    }
}
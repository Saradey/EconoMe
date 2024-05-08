package evgenii.goncharov.econome.bank_accounts_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.bank_accounts_impl.di.contracts.AddPatternAccountInternal
import evgenii.goncharov.econome.bank_accounts_impl.di.modules.AddPatternAccountBindModule
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope

@FeatureScope
@Component(
    modules = [
        AddPatternAccountBindModule::class
    ]
)
internal interface AddPatternAccountComponent : AddPatternAccountInternal {

    @Component.Factory
    interface Factory {

        fun create(): AddPatternAccountComponent
    }
}
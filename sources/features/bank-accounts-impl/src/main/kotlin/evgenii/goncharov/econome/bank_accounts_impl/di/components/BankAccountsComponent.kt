package evgenii.goncharov.econome.bank_accounts_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.bank_accounts_impl.di.contracts.BankAccountsInternal
import evgenii.goncharov.econome.bank_accounts_impl.di.modules.BankAccountsViewModelBindsModule
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope

@FeatureScope
@Component(
    modules = [
        BankAccountsViewModelBindsModule::class
    ]
)
internal interface BankAccountsComponent : BankAccountsInternal {

    @Component.Factory
    interface Factory {

        fun create(): BankAccountsComponent
    }
}
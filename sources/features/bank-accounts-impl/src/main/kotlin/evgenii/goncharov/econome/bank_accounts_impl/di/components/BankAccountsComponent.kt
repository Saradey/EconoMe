package evgenii.goncharov.econome.bank_accounts_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.bank_accounts_api.navigation.BankAccountsLauncher
import evgenii.goncharov.econome.bank_accounts_impl.di.contracts.BankAccountsInternal
import evgenii.goncharov.econome.bank_accounts_impl.di.modules.BankAccountsBindModule
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope

@FeatureScope
@Component(
    modules = [
        BankAccountsBindModule::class
    ]
)
internal interface BankAccountsComponent : BankAccountsInternal {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance bankAccountsLauncher: BankAccountsLauncher
        ): BankAccountsComponent
    }
}
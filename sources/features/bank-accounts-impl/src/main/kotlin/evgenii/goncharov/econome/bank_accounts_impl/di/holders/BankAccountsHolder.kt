package evgenii.goncharov.econome.bank_accounts_impl.di.holders

import evgenii.goncharov.econome.bank_accounts_api.di.BankAccountsApi
import evgenii.goncharov.econome.bank_accounts_api.navigation.BankAccountsLauncher
import evgenii.goncharov.econome.bank_accounts_impl.di.components.DaggerBankAccountsComponent
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import javax.inject.Inject

public class BankAccountsHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<BankAccountsApi>(container) {

    override fun buildComponent(): BankAccountsApi {
        return DaggerBankAccountsComponent.factory().create(
            bankAccountsLauncher = getFeatureLauncher(BankAccountsLauncher::class.java)
        )
    }
}
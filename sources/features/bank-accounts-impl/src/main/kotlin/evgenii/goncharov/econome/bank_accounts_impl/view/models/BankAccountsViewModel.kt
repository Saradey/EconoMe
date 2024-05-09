package evgenii.goncharov.econome.bank_accounts_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.bank_accounts_api.navigation.BankAccountsLauncher
import javax.inject.Inject

internal class BankAccountsViewModel @Inject constructor(
    private val bankAccountsLauncher: BankAccountsLauncher
) : ViewModel() {

    fun navigateToAddStateAccount() {
        bankAccountsLauncher.launchAddStateAccount()
    }

    fun navigateToAddPatternAccount() {
        bankAccountsLauncher.launchAddPatternAccount()
    }
}
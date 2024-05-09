package evgenii.goncharov.econome.bank_accounts_api.navigation

import evgenii.goncharov.econome.di_core.contracts.BaseLauncher

public interface BankAccountsLauncher : BaseLauncher {

    public fun deepLaunchBankAccounts()

    public fun launchAddStateAccount()

    public fun launchAddPatternAccount()
}
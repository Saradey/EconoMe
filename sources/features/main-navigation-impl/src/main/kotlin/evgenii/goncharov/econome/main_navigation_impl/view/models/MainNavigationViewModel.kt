package evgenii.goncharov.econome.main_navigation_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.all_spending_api.navigation.AllSpendingLauncher
import evgenii.goncharov.econome.bank_accounts_api.navigation.BankAccountsLauncher
import evgenii.goncharov.econome.finance_analysis_api.navigation.FinanceAnalyticsAllSpendingLauncher
import evgenii.goncharov.econome.main_api.navigation.MainLauncher
import evgenii.goncharov.econome.settings_api.navigation.SettingsLauncher
import javax.inject.Inject

internal class MainNavigationViewModel @Inject constructor(
    private val mainLauncher: MainLauncher,
    private val allSpendingLauncher: AllSpendingLauncher,
    private val financeAnalyticsAllSpendingLauncher: FinanceAnalyticsAllSpendingLauncher,
    private val bankAccountsLauncher: BankAccountsLauncher,
    private val settingsLauncher: SettingsLauncher
) : ViewModel() {

}
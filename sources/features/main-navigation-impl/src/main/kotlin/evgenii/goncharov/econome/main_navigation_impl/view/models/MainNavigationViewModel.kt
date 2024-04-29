package evgenii.goncharov.econome.main_navigation_impl.view.models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.all_spending_api.navigation.AllSpendingLauncher
import evgenii.goncharov.econome.bank_accounts_api.navigation.BankAccountsLauncher
import evgenii.goncharov.econome.finance_analysis_api.navigation.FinanceAnalyticsAllSpendingLauncher
import evgenii.goncharov.econome.main_api.navigation.MainLauncher
import evgenii.goncharov.econome.main_navigation_impl.models.MainNavigationState
import evgenii.goncharov.econome.main_navigation_impl.utils.NavigationTabs
import evgenii.goncharov.econome.main_navigation_impl.utils.createBottomNavigationItems
import evgenii.goncharov.econome.settings_api.navigation.SettingsLauncher
import javax.inject.Inject

internal class MainNavigationViewModel @Inject constructor(
    private val mainLauncher: MainLauncher,
    private val allSpendingLauncher: AllSpendingLauncher,
    private val financeAnalyticsAllSpendingLauncher: FinanceAnalyticsAllSpendingLauncher,
    private val bankAccountsLauncher: BankAccountsLauncher,
    private val settingsLauncher: SettingsLauncher
) : ViewModel() {

    private val _uiState = mutableStateOf(
        MainNavigationState.Content(
            createBottomNavigationItems()
        )
    )
    val uiState: State<MainNavigationState> = _uiState

    fun selectedTab(tab: NavigationTabs) {
        updateBottomMenuState(tab)
    }

    private fun updateBottomMenuState(tab: NavigationTabs) {
        _uiState.value = _uiState.value.copy(
            mainMenuItems = _uiState.value.mainMenuItems.map { oldItem ->
                oldItem.copy(
                    isSelected = oldItem.tab == tab
                )
            }
        )
    }
}
package evgenii.goncharov.econome.main_navigation_impl.di.holder

import evgenii.goncharov.econome.all_spending_api.navigation.AllSpendingLauncher
import evgenii.goncharov.econome.bank_accounts_api.navigation.BankAccountsLauncher
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.finance_analysis_api.navigation.FinanceAnalyticsAllSpendingLauncher
import evgenii.goncharov.econome.main_api.navigation.MainLauncher
import evgenii.goncharov.econome.main_navigation.di.MainNavigationApi
import evgenii.goncharov.econome.main_navigation_impl.di.components.DaggerMainNavigationComponent
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi
import evgenii.goncharov.econome.settings_api.navigation.SettingsLauncher
import javax.inject.Inject

public class MainNavigationHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<MainNavigationApi>(container) {

    override fun buildComponent(): MainNavigationApi {
        return DaggerMainNavigationComponent.factory().create(
            mainLauncher = getFeatureLauncher(MainLauncher::class.java),
            allSpendingLauncher = getFeatureLauncher(AllSpendingLauncher::class.java),
            financeAnalyticsAllSpendingLauncher = getFeatureLauncher(
                FinanceAnalyticsAllSpendingLauncher::class.java
            ),
            bankAccountsLauncher = getFeatureLauncher(BankAccountsLauncher::class.java),
            settingsLauncher = getFeatureLauncher(SettingsLauncher::class.java),
            coreNavigationApi = getGlobalComponent(CoreNavigationApi::class.java)
        )
    }
}
package evgenii.goncharov.econome.main_navigation_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.all_spending_api.navigation.AllSpendingLauncher
import evgenii.goncharov.econome.bank_accounts_api.navigation.BankAccountsLauncher
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.finance_analysis_api.navigation.FinanceAnalyticsAllSpendingLauncher
import evgenii.goncharov.econome.main_api.navigation.MainLauncher
import evgenii.goncharov.econome.main_navigation_impl.di.contracts.MainNavigationInternal
import evgenii.goncharov.econome.main_navigation_impl.di.modules.MainNavigationViewModelBindsModule
import evgenii.goncharov.econome.settings_api.navigation.SettingsLauncher

@FeatureScope
@Component(
    modules = [MainNavigationViewModelBindsModule::class]
)
internal interface MainNavigationComponent : MainNavigationInternal {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance mainLauncher: MainLauncher,
            @BindsInstance allSpendingLauncher: AllSpendingLauncher,
            @BindsInstance financeAnalyticsAllSpendingLauncher: FinanceAnalyticsAllSpendingLauncher,
            @BindsInstance bankAccountsLauncher: BankAccountsLauncher,
            @BindsInstance settingsLauncher: SettingsLauncher
        ): MainNavigationComponent
    }
}
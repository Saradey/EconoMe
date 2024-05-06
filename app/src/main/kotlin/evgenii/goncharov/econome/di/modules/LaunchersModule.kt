package evgenii.goncharov.econome.di.modules

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.all_spending_api.navigation.AllSpendingLauncher
import evgenii.goncharov.econome.all_spending_impl.navigation.AllSpendingLauncherImpl
import evgenii.goncharov.econome.bank_accounts_api.navigation.BankAccountsLauncher
import evgenii.goncharov.econome.bank_accounts_impl.navigation.BankAccountsLauncherImpl
import evgenii.goncharov.econome.di_core.contracts.BaseLauncher
import evgenii.goncharov.econome.finance_analysis_api.navigation.FinanceAnalyticsAllSpendingLauncher
import evgenii.goncharov.econome.finance_analysis_impl.navigation.FinanceAnalyticsAllSpendingLauncherImpl
import evgenii.goncharov.econome.main_api.navigation.MainLauncher
import evgenii.goncharov.econome.main_impl.navigation.MainLauncherImpl
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import evgenii.goncharov.econome.main_navigation_impl.navigation.MainNavigationLauncherImpl
import evgenii.goncharov.econome.settings_api.navigation.SettingsLauncher
import evgenii.goncharov.econome.settings_impl.navigation.SettingsLauncherImpl
import evgenii.goncharov.econome.spending_api.navigation.SpendingLauncher
import evgenii.goncharov.econome.spending_impl.navigation.SpendingLauncherImpl
import evgenii.goncharov.econome.user_api.navigation.UserLauncher
import evgenii.goncharov.econome.user_impl.navigation.UserLauncherImpl
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher
import evgenii.goncharov.econome.wallet_impl.navigation.WalletLauncherImpl
import javax.inject.Singleton

@Module
interface LaunchersModule {

    @[Binds Singleton IntoMap ClassKey(UserLauncher::class)]
    fun bindUserLauncher(userLauncher: UserLauncherImpl): BaseLauncher

    @[Binds Singleton IntoMap ClassKey(MainNavigationLauncher::class)]
    fun bindMainNavigationLauncher(userLauncher: MainNavigationLauncherImpl): BaseLauncher

    @[Binds Singleton IntoMap ClassKey(MainLauncher::class)]
    fun bindMainLauncher(mainLauncher: MainLauncherImpl): BaseLauncher

    @[Binds Singleton IntoMap ClassKey(AllSpendingLauncher::class)]
    fun bindAllSpendingLauncher(mainLauncher: AllSpendingLauncherImpl): BaseLauncher

    @[Binds Singleton IntoMap ClassKey(FinanceAnalyticsAllSpendingLauncher::class)]
    fun bindFinanceAnalyticsAllSpendingLauncher(mainLauncher: FinanceAnalyticsAllSpendingLauncherImpl): BaseLauncher

    @[Binds Singleton IntoMap ClassKey(BankAccountsLauncher::class)]
    fun bindBankAccountsLauncher(mainLauncher: BankAccountsLauncherImpl): BaseLauncher

    @[Binds Singleton IntoMap ClassKey(SettingsLauncher::class)]
    fun bindSettingsLauncher(mainLauncher: SettingsLauncherImpl): BaseLauncher

    @[Binds Singleton IntoMap ClassKey(WalletLauncher::class)]
    fun bindWalletLauncher(mainLauncher: WalletLauncherImpl): BaseLauncher

    @[Binds Singleton IntoMap ClassKey(SpendingLauncher::class)]
    fun bindSpendingLauncher(mainLauncher: SpendingLauncherImpl): BaseLauncher
}
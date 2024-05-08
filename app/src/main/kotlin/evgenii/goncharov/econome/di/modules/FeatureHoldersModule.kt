package evgenii.goncharov.econome.di.modules

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.all_spending_api.di.AllSpendingApi
import evgenii.goncharov.econome.all_spending_impl.di.holders.AllSpendingHolder
import evgenii.goncharov.econome.bank_accounts_api.di.AddStateAccountApi
import evgenii.goncharov.econome.bank_accounts_api.di.BankAccountsApi
import evgenii.goncharov.econome.bank_accounts_impl.di.holders.AddStateAccountHolder
import evgenii.goncharov.econome.bank_accounts_impl.di.holders.BankAccountsHolder
import evgenii.goncharov.econome.main_activity.di.contracts.MainActivityApi
import evgenii.goncharov.econome.main_activity.di.holder.MainActivityHolder
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.finance_analysis_api.di.FinanceAnalyticsAllSpendingApi
import evgenii.goncharov.econome.finance_analysis_api.di.FinanceAnalyticsApi
import evgenii.goncharov.econome.finance_analysis_impl.di.holders.FinanceAnalyticsAllSpendingHolder
import evgenii.goncharov.econome.finance_analysis_impl.di.holders.FinanceAnalyticsHolder
import evgenii.goncharov.econome.main_api.di.MainApi
import evgenii.goncharov.econome.main_api.di.SpendingLimitApi
import evgenii.goncharov.econome.main_impl.di.holders.MainHolder
import evgenii.goncharov.econome.main_impl.di.holders.SpendingLimitHolder
import evgenii.goncharov.econome.main_navigation.di.MainNavigationApi
import evgenii.goncharov.econome.main_navigation_impl.di.holder.MainNavigationHolder
import evgenii.goncharov.econome.product_cost_analysis_api.di.AddCostGoodsApi
import evgenii.goncharov.econome.product_cost_analysis_api.di.ListShopsApi
import evgenii.goncharov.econome.product_cost_analysis_impl.di.holders.AddCostGoodsHolder
import evgenii.goncharov.econome.product_cost_analysis_impl.di.holders.ListShopsHolder
import evgenii.goncharov.econome.settings_api.di.SettingsApi
import evgenii.goncharov.econome.settings_impl.di.holder.SettingsHolder
import evgenii.goncharov.econome.spending_api.di.AddSpendingApi
import evgenii.goncharov.econome.spending_api.di.SpendingInfoApi
import evgenii.goncharov.econome.spending_impl.di.holders.AddSpendingHolder
import evgenii.goncharov.econome.spending_impl.di.holders.SpendingInfoHolder
import evgenii.goncharov.econome.user_api.di.UserChoosingApi
import evgenii.goncharov.econome.user_api.di.UserCreatorApi
import evgenii.goncharov.econome.user_impl.di.holder.UserChoosingHolder
import evgenii.goncharov.econome.user_impl.di.holder.UserCreatorHolder
import evgenii.goncharov.econome.wallet_api.di.WalletCreatorApi
import evgenii.goncharov.econome.wallet_impl.di.holder.WalletCreatorHolder
import javax.inject.Singleton

@Module
interface FeatureHoldersModule {

    @[Binds Singleton IntoMap ClassKey(MainActivityApi::class)]
    fun bindMainActivityHolder(holder: MainActivityHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(UserCreatorApi::class)]
    fun bindUserCreatorHolder(holder: UserCreatorHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(UserChoosingApi::class)]
    fun bindUserChoosingHolder(holder: UserChoosingHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(MainNavigationApi::class)]
    fun bindMainNavigationHolder(holder: MainNavigationHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(MainApi::class)]
    fun bindMainHolder(holder: MainHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(AllSpendingApi::class)]
    fun bindAllSpendingHolder(holder: AllSpendingHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(FinanceAnalyticsAllSpendingApi::class)]
    fun bindFinanceAnalyticsAllSpendingHolder(holder: FinanceAnalyticsAllSpendingHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(BankAccountsApi::class)]
    fun bindBankAccountsHolder(holder: BankAccountsHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(SettingsApi::class)]
    fun bindSettingsHolder(holder: SettingsHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(WalletCreatorApi::class)]
    fun bindWalletCreatorHolder(holder: WalletCreatorHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(AddSpendingApi::class)]
    fun bindAddSpendingHolder(holder: AddSpendingHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(SpendingInfoApi::class)]
    fun bindSpendingInfoHolder(holder: SpendingInfoHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(SpendingLimitApi::class)]
    fun bindSpendingLimitHolder(holder: SpendingLimitHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(ListShopsApi::class)]
    fun bindListShopsHolder(holder: ListShopsHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(AddCostGoodsApi::class)]
    fun bindAddCostGoodsHolder(holder: AddCostGoodsHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(FinanceAnalyticsApi::class)]
    fun bindFinanceAnalyticsHolder(holder: FinanceAnalyticsHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(AddStateAccountApi::class)]
    fun bindAddStateAccountHolder(holder: AddStateAccountHolder): FeatureHolder<*>
}
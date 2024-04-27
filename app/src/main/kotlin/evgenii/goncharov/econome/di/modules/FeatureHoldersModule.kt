package evgenii.goncharov.econome.di.modules

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.all_spending_api.di.AllSpendingApi
import evgenii.goncharov.econome.bank_accounts_impl.di.holders.BankAccountsHolder
import evgenii.goncharov.econome.main_activity.di.contracts.MainActivityApi
import evgenii.goncharov.econome.main_activity.di.holder.MainActivityHolder
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.finance_analysis_api.di.FinanceAnalyticsAllSpendingApi
import evgenii.goncharov.econome.finance_analysis_impl.di.holders.FinanceAnalyticsAllSpendingHolder
import evgenii.goncharov.econome.main_api.di.MainApi
import evgenii.goncharov.econome.main_impl.di.holders.MainHolder
import evgenii.goncharov.econome.main_navigation.di.MainNavigationApi
import evgenii.goncharov.econome.main_navigation_impl.di.holder.MainNavigationHolder
import evgenii.goncharov.econome.user_api.di.UserChoosingApi
import evgenii.goncharov.econome.user_api.di.UserCreatorApi
import evgenii.goncharov.econome.user_impl.di.holder.UserChoosingHolder
import evgenii.goncharov.econome.user_impl.di.holder.UserCreatorHolder
import javax.inject.Singleton

@Module
interface FeatureHoldersModule {

    @[Binds Singleton IntoMap ClassKey(MainActivityApi::class)]
    fun bindMainActivityHolder(mainActivityHolder: MainActivityHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(UserCreatorApi::class)]
    fun bindUserCreatorHolder(mainActivityHolder: UserCreatorHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(UserChoosingApi::class)]
    fun bindUserChoosingHolder(mainActivityHolder: UserChoosingHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(MainNavigationApi::class)]
    fun bindMainNavigationHolder(mainActivityHolder: MainNavigationHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(MainApi::class)]
    fun bindMainHolder(mainHolder: MainHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(AllSpendingApi::class)]
    fun bindAllSpendingHolder(mainHolder: BankAccountsHolder): FeatureHolder<*>

    @[Binds Singleton IntoMap ClassKey(FinanceAnalyticsAllSpendingApi::class)]
    fun bindFinanceAnalyticsAllSpendingHolder(mainHolder: FinanceAnalyticsAllSpendingHolder): FeatureHolder<*>
}
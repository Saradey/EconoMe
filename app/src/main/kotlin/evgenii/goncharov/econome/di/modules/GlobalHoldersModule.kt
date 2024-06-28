package evgenii.goncharov.econome.di.modules

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.category.api.DefaultCategoryApi
import evgenii.goncharov.econome.category.di.holder.DefaultCategoryHolder
import evgenii.goncharov.econome.common_provider.di.api.CommonProviderApi
import evgenii.goncharov.econome.common_provider.di.holder.CommonProviderHolder
import evgenii.goncharov.econome.core_database_api.api.CoreDatabaseApi
import evgenii.goncharov.econome.core_database_impl.di.holder.CoreDatabaseHolder
import evgenii.goncharov.econome.currency.api.CurrencyApi
import evgenii.goncharov.econome.currency.di.holder.CurrencyHolder
import evgenii.goncharov.econome.current_user.di.api.CurrentApi
import evgenii.goncharov.econome.current_user.di.holder.CurrentHolder
import evgenii.goncharov.econome.di.holder.LaunchersHolder
import evgenii.goncharov.econome.di_core.contracts.LaunchersApi
import evgenii.goncharov.econome.di_core.holders.BaseHolder
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi
import evgenii.goncharov.econome.navigation.holder.NavigationHolder
import javax.inject.Singleton

@Module
interface GlobalHoldersModule {

    @[Binds Singleton IntoMap ClassKey(LaunchersApi::class)]
    fun bindLaunchersHolder(holder: LaunchersHolder): BaseHolder<*>

    @[Binds Singleton IntoMap ClassKey(CoreNavigationApi::class)]
    fun bindNavigationHolder(holder: NavigationHolder): BaseHolder<*>

    @[Binds Singleton IntoMap ClassKey(CommonProviderApi::class)]
    fun bindCommonProviderHolder(holder: CommonProviderHolder): BaseHolder<*>

    @[Binds Singleton IntoMap ClassKey(CoreDatabaseApi::class)]
    fun bindCoreDatabaseHolder(holder: CoreDatabaseHolder): BaseHolder<*>

    @[Binds Singleton IntoMap ClassKey(CurrencyApi::class)]
    fun bindCurrencyHolder(holder: CurrencyHolder): BaseHolder<*>

    @[Binds Singleton IntoMap ClassKey(CurrentApi::class)]
    fun bindCurrentHolder(holder: CurrentHolder): BaseHolder<*>

    @[Binds Singleton IntoMap ClassKey(DefaultCategoryApi::class)]
    fun bindDefaultCategoryHolder(holder: DefaultCategoryHolder): BaseHolder<*>
}
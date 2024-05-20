package evgenii.goncharov.econome.di.modules

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common_provider.di.CommonProviderApi
import evgenii.goncharov.econome.common_provider.di.CommonProviderHolder
import evgenii.goncharov.econome.core_database_api.di.CoreDatabaseApi
import evgenii.goncharov.econome.core_database_impl.di.holder.CoreDatabaseHolder
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
}
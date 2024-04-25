package evgenii.goncharov.econome.di.modules

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.di.holder.LaunchersHolder
import evgenii.goncharov.econome.di_core.contracts.LaunchersApi
import evgenii.goncharov.econome.di_core.holders.BaseHolder
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi
import evgenii.goncharov.econome.navigation.holder.NavigationHolder
import javax.inject.Singleton

@Module
interface GlobalHoldersModule {

    @[Binds Singleton IntoMap ClassKey(LaunchersApi::class)]
    fun bindLaunchersHolder(launchersHolder: LaunchersHolder): BaseHolder<*>

    @[Binds Singleton IntoMap ClassKey(CoreNavigationApi::class)]
    fun bindNavigationHolder(navigationHolder: NavigationHolder): BaseHolder<*>
}
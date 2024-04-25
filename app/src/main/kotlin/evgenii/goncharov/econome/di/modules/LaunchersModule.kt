package evgenii.goncharov.econome.di.modules

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.di_core.contracts.BaseLauncher
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import evgenii.goncharov.econome.main_navigation_impl.navigation.MainNavigationLauncherImpl
import evgenii.goncharov.econome.user_api.navigation.UserLauncher
import evgenii.goncharov.econome.user_impl.navigation.UserLauncherImpl
import javax.inject.Singleton

@Module
interface LaunchersModule {

    @[Binds Singleton IntoMap ClassKey(UserLauncher::class)]
    fun bindUserLauncher(userLauncher: UserLauncherImpl): BaseLauncher

    @[Binds Singleton IntoMap ClassKey(MainNavigationLauncher::class)]
    fun bindMainNavigationLauncher(userLauncher: MainNavigationLauncherImpl): BaseLauncher
}
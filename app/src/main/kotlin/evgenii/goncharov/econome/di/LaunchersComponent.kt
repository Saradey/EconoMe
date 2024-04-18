package evgenii.goncharov.econome.di

import dagger.Component
import evgenii.goncharov.econome.di.modules.LauncherModule
import evgenii.goncharov.econome.di_core.contracts.LaunchersApi
import evgenii.goncharov.econome.navigation.CoreNavigationApi
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CoreNavigationApi::class],
    modules = [LauncherModule::class]
)
interface LaunchersComponent : LaunchersApi
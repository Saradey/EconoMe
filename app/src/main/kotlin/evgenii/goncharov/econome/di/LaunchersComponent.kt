package evgenii.goncharov.econome.di

import dagger.Component
import evgenii.goncharov.econome.di.modules.LaunchersModule
import evgenii.goncharov.econome.di_core.contracts.LaunchersApi
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [CoreNavigationApi::class],
    modules = [LaunchersModule::class]
)
interface LaunchersComponent : LaunchersApi
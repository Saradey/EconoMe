package evgenii.goncharov.econome.di.modules

import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.di.holder.LaunchersHolder
import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager
import evgenii.goncharov.econome.di_core.contracts.LaunchersApi
import evgenii.goncharov.econome.di_core.holders.BaseHolder
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi
import evgenii.goncharov.econome.navigation.holder.NavigationHolder
import javax.inject.Singleton

@Module
object GlobalHoldersModule {

    @[Provides Singleton]
    @[IntoMap ClassKey(LaunchersApi::class)]
    fun provideLaunchersHolder(featureContainer: FeatureContainerManager): BaseHolder<*> =
        LaunchersHolder(featureContainer)

    @[Provides Singleton]
    @[IntoMap ClassKey(CoreNavigationApi::class)]
    fun provideNavigationHolder(featureContainer: FeatureContainerManager): BaseHolder<*> =
        NavigationHolder(featureContainer)
}
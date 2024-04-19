package evgenii.goncharov.econome.di.modules

import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.main_activity.di.contracts.MainActivityApi
import evgenii.goncharov.econome.main_activity.di.holder.MainActivityHolder
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import javax.inject.Singleton

@Module
object FeatureHoldersModule {

    @[Singleton Provides]
    @[IntoMap ClassKey(MainActivityApi::class)]
    fun provideMainActivityHolder(featureContainer: FeatureContainer): FeatureHolder<*> =
        MainActivityHolder(featureContainer)
}
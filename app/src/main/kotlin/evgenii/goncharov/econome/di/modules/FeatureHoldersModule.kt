package evgenii.goncharov.econome.di.modules

import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.main_activity.di.contracts.MainActivityApi
import evgenii.goncharov.econome.main_activity.di.holder.MainActivityHolder
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import javax.inject.Singleton

@Module
interface FeatureHoldersModule {

    @[Binds Singleton IntoMap ClassKey(MainActivityApi::class)]
    fun provideMainActivityHolder(mainActivityHolder: MainActivityHolder): FeatureHolder<*>
}
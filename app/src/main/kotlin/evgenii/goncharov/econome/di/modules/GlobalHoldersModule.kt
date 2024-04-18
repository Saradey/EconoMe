package evgenii.goncharov.econome.di.modules

import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.di.stub.StubGlobalApi
import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager
import evgenii.goncharov.econome.di_core.holders.BaseHolder
import javax.inject.Singleton

@Module
object GlobalHoldersModule {

    @[Provides Singleton]
    @[IntoMap ClassKey(StubGlobalApi::class)]
    fun provideNavigationHolder(featureContainer: FeatureContainerManager): BaseHolder<*> =
        object : BaseHolder<StubGlobalApi>(featureContainer) {
            override fun buildComponent(): StubGlobalApi {
                return object : StubGlobalApi {}
            }
        }
}
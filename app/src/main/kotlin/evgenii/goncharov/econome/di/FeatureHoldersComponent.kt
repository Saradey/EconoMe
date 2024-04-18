package evgenii.goncharov.econome.di

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.di.modules.FeatureHoldersModule
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import javax.inject.Singleton

@Singleton
@Component(
    modules = [FeatureHoldersModule::class]
)
interface FeatureHoldersComponent {

    fun getFeatureHolders(): Map<Class<*>, FeatureHolder<*>>

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance featureContainerManager: FeatureContainer
        ): FeatureHoldersComponent
    }
}
package evgenii.goncharov.econome.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.di.modules.GlobalHoldersModule
import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager
import evgenii.goncharov.econome.di_core.holders.BaseHolder
import javax.inject.Singleton

@Singleton
@Component(
    modules = [GlobalHoldersModule::class]
)
interface GlobalHoldersComponent {

    fun getGlobalHolders(): Map<Class<*>, BaseHolder<*>>

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance appContext: Context,
            @BindsInstance featureContainerManager: FeatureContainerManager,
        ): GlobalHoldersComponent
    }
}
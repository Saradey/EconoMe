package evgenii.goncharov.econome.initializer

import android.content.Context
import evgenii.goncharov.econome.di.components.DaggerGlobalHoldersComponent
import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager
import evgenii.goncharov.econome.di_core.holders.BaseHolder
import evgenii.goncharov.econome.di_core.initializer.GlobalHolderInitializer

class GlobalHolderInitializerImpl(
    private val appContext: Context,
) : GlobalHolderInitializer {

    override fun init(featureContainerManager: FeatureContainerManager): Map<Class<*>, BaseHolder<*>> {
        return DaggerGlobalHoldersComponent.factory().create(
            appContext,
            featureContainerManager,
        ).getGlobalHolders()
    }
}
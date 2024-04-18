package evgenii.goncharov.econome.initializer

import evgenii.goncharov.econome.di.DaggerFeatureHoldersComponent
import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.di_core.initializer.FeatureHolderInitializer

class FeatureHolderInitializerImpl : FeatureHolderInitializer {

    override fun init(featureContainerManager: FeatureContainerManager): Map<Class<*>, FeatureHolder<*>> {
        return DaggerFeatureHoldersComponent.factory().create(
            featureContainerManager
        ).getFeatureHolders()
    }
}
package evgenii.goncharov.econome.di_core.initializer

import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager
import evgenii.goncharov.econome.di_core.holders.FeatureHolder

public interface FeatureHolderInitializer {

    public fun init(featureContainerManager: FeatureContainerManager): Map<Class<*>, FeatureHolder<*>>
}
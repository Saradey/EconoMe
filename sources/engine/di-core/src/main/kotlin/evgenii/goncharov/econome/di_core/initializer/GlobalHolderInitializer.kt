package evgenii.goncharov.econome.di_core.initializer

import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager

public interface GlobalHolderInitializer {

    public fun init(featureContainerManager: FeatureContainerManager): Map<Class<*>, BaseHolder<*>>
}
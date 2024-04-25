package evgenii.goncharov.econome.di_core.containers

import evgenii.goncharov.econome.di_core.initializer.FeatureHolderInitializer
import evgenii.goncharov.econome.di_core.initializer.GlobalHolderInitializer

public interface FeatureContainerManager : FeatureContainer {

    public fun init(
        globalInitializer: GlobalHolderInitializer,
        featureInitializer: FeatureHolderInitializer
    ): FeatureContainerManager
}
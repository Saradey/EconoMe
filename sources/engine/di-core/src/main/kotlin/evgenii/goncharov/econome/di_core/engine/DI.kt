package evgenii.goncharov.econome.di_core.engine

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.containers.FeatureContainerImpl
import evgenii.goncharov.econome.di_core.containers.NotInitializedFeatureContainer
import evgenii.goncharov.econome.di_core.contracts.BaseLauncher
import evgenii.goncharov.econome.di_core.contracts.ReleasableApi
import evgenii.goncharov.econome.di_core.initializer.FeatureHolderInitializer
import evgenii.goncharov.econome.di_core.initializer.GlobalHolderInitializer

public object DI {

    private var featureContainer: FeatureContainer = NotInitializedFeatureContainer

    public fun initialize(
        globalHolderInitializer: GlobalHolderInitializer,
        featureHolderInitializer: FeatureHolderInitializer
    ) {
        val featureContainer = FeatureContainerImpl()
        featureContainer.init(
            globalHolderInitializer,
            featureHolderInitializer
        )
        this.featureContainer = featureContainer
    }

    public fun getFeatureApi(key: Class<out ReleasableApi>): ReleasableApi {
        return featureContainer.getFeatureComponent(key)
    }

    public fun releaseFeatureApi(key: Class<out ReleasableApi>) {
        featureContainer.releaseFeatureComponent(key)
    }

    public fun <D> getGlobalApi(key: Class<D>): D {
        return featureContainer.getGlobalComponent(key)
    }

    public fun <L : BaseLauncher> getFeatureLauncher(key: Class<L>): BaseLauncher {
        return featureContainer.getFeatureLauncher(key)
    }
}
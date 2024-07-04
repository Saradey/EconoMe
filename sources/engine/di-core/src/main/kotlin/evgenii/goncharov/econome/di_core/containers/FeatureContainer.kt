package evgenii.goncharov.econome.di_core.containers

import evgenii.goncharov.econome.di_core.contracts.BaseLauncher
import evgenii.goncharov.econome.di_core.contracts.ReleasableApi

public interface FeatureContainer {

    public fun getNullableFeatureComponent(key: Class<out ReleasableApi>): ReleasableApi?

    public fun getFeatureComponent(key: Class<out ReleasableApi>): ReleasableApi

    public fun getFeatureComponent(
        key: Class<out ReleasableApi>,
        arguments: Map<String, Any?>
    ): ReleasableApi

    public fun releaseFeatureComponent(key: Class<out ReleasableApi>)

    public fun <D> getGlobalComponent(key: Class<D>): D

    public fun <L : BaseLauncher> getFeatureLauncher(key: Class<L>): BaseLauncher
}
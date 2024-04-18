package evgenii.goncharov.econome.di_core.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.contracts.BaseLauncher
import evgenii.goncharov.econome.di_core.contracts.ReleasableApi

public abstract class FeatureHolder<C : ReleasableApi>(container: FeatureContainer) :
    BaseHolder<C>(container) {

    public fun releaseFeature() {
        componentApi = null
    }

    @Suppress("UNCHECKED_CAST")
    protected fun <L : BaseLauncher> getFeatureLauncher(key: Class<L>): L {
        return container.getFeatureLauncher(key) as L
    }
}
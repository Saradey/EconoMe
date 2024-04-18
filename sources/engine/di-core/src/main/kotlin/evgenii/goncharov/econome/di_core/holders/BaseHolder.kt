package evgenii.goncharov.econome.di_core.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.contracts.ReleasableApi

public abstract class BaseHolder<C>(protected val container: FeatureContainer) {

    protected var componentApi: C? = null

    public fun getComponent(): C {
        return componentApi ?: buildComponent().apply {
            componentApi = this@apply
        }
    }

    protected abstract fun buildComponent(): C

    protected fun <CG> getGlobalComponent(key: Class<CG>): CG {
        return container.getGlobalComponent(key)
    }

    @Suppress("UNCHECKED_CAST")
    protected fun <FC : ReleasableApi> getFeatureComponent(key: Class<out ReleasableApi>): FC {
        return container.getFeatureComponent(key) as FC
    }
}
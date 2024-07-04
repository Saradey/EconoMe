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

    public fun getComponentWithoutBuild(): C? {
        return componentApi
    }

    protected open fun buildComponent(): C {
        throw ExceptionInInitializerError(ERROR_MESSAGE_INIT_WITH_ARGS)
    }

    protected open fun buildComponentWithParameters(arguments: Map<String, Any>): C {
        throw ExceptionInInitializerError(ERROR_MESSAGE_INIT_WITH_ARGS)
    }

    protected fun <CG> getGlobalComponent(key: Class<CG>): CG {
        return container.getGlobalComponent(key)
    }

    @Suppress("UNCHECKED_CAST")
    protected fun <FC : ReleasableApi> getFeatureComponent(key: Class<out ReleasableApi>): FC? {
        return container.getNullableFeatureComponent(key) as FC?
    }

    private companion object {

        const val ERROR_MESSAGE_INIT_WITH_ARGS = "Need override this method"
    }
}
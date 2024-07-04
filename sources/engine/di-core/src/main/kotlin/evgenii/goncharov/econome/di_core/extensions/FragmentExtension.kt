package evgenii.goncharov.econome.di_core.extensions

import evgenii.goncharov.econome.di_core.contracts.ReleasableApi
import evgenii.goncharov.econome.di_core.engine.DI

public fun getFeatureApi(key: Class<out ReleasableApi>): ReleasableApi =
    DI.getFeatureApi(key)

public fun getFeatureApiWithParameters(
    key: Class<out ReleasableApi>,
    parameters: Map<String, Any?>
): ReleasableApi =
    DI.getFeatureApi(key)

public fun releaseFeatureApi(key: Class<out ReleasableApi>) {
    DI.releaseFeatureApi(key)
}


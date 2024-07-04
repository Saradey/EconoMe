package evgenii.goncharov.econome.di_core.extensions

import androidx.fragment.app.Fragment
import evgenii.goncharov.econome.di_core.contracts.ReleasableApi
import evgenii.goncharov.econome.di_core.engine.DI

public fun Fragment.getFeatureApi(key: Class<out ReleasableApi>): ReleasableApi =
    DI.getFeatureApi(key)
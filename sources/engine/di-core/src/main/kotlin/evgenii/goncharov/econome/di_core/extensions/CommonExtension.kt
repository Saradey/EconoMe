package evgenii.goncharov.econome.di_core.extensions

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import evgenii.goncharov.econome.di_core.contracts.ReleasableApi
import evgenii.goncharov.econome.di_core.engine.DI

internal fun makeUiContainer(
    context: Context,
    content: @Composable () -> Unit
): View {
    return ComposeView(context).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        setContent {
            content()
        }
    }
}

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
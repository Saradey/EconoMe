package evgenii.goncharov.econome.di_core.utils

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView

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
package evgenii.goncharov.econome.di_core

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import evgenii.goncharov.econome.di_core.contracts.ReleasableApi
import evgenii.goncharov.econome.di_core.engine.DI

public abstract class CoreFragment : Fragment(R.layout.fragment_core) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val container = view.findViewById<ComposeView>(R.id.cv_container)
        container.setContent {
            InitContent()
        }
    }

    @Composable
    public abstract fun InitContent()

    protected fun getFeatureApi(key: Class<out ReleasableApi>): ReleasableApi =
        DI.getFeatureApi(key)

    protected abstract fun releaseDependencies()

    protected fun releaseFeatureApi(key: Class<out ReleasableApi>) {
        DI.releaseFeatureApi(key)
    }
}
package evgenii.goncharov.econome.di_core

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import evgenii.goncharov.econome.di_core.contracts.ReleasableApi
import evgenii.goncharov.econome.di_core.engine.DI

public abstract class CoreBottomSheetFragment : BottomSheetDialogFragment(R.layout.fragment_core) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val container = view.findViewById<ComposeView>(R.id.cv_container)
        container.setContent {
            InitContent()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseDependencies()
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
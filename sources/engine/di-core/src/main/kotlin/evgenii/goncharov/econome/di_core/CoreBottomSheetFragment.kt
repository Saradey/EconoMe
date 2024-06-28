package evgenii.goncharov.econome.di_core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import evgenii.goncharov.econome.di_core.contracts.ReleasableApi
import evgenii.goncharov.econome.di_core.engine.DI
import evgenii.goncharov.econome.di_core.utils.makeUiContainer

public abstract class CoreBottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return makeUiContainer(
            context = requireContext(),
            content = { InitContent() }
        )
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
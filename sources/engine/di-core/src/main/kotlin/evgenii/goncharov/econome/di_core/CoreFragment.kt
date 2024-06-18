package evgenii.goncharov.econome.di_core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import evgenii.goncharov.econome.di_core.contracts.ReleasableApi
import evgenii.goncharov.econome.di_core.engine.DI
import evgenii.goncharov.econome.di_core.utils.makeUiContainer

public abstract class CoreFragment : Fragment() {

    @LayoutRes
    protected open var layoutId: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (layoutId == -1) {
            makeUiContainer(
                context = requireContext(),
                content = { InitContent() }
            )
        } else {
            inflater.inflate(layoutId, container, false)
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
package evgenii.goncharov.econome.di_core

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import evgenii.goncharov.econome.di_core.contracts.ReleasableApi
import evgenii.goncharov.econome.di_core.engine.DI

public abstract class ContainerFeatureFragment : Fragment {

    public constructor(@LayoutRes layoutId: Int) : super(layoutId)
    public constructor() : super(R.layout.fragment_feature_container)

    protected abstract val navigatorHolder: NavigatorHolder
    protected abstract val navigator: Navigator

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        releaseDependencies()
    }

    protected abstract fun releaseDependencies()

    protected fun getFeatureApi(key: Class<out ReleasableApi>): ReleasableApi =
        DI.getFeatureApi(key)

    protected fun releaseFeatureApi(key: Class<out ReleasableApi>) {
        DI.releaseFeatureApi(key)
    }
}
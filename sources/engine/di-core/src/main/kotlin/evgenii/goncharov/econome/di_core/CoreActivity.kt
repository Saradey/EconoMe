package evgenii.goncharov.econome.di_core

import androidx.appcompat.app.AppCompatActivity
import evgenii.goncharov.econome.di_core.contracts.ReleasableApi
import evgenii.goncharov.econome.di_core.engine.DI

public abstract class CoreActivity : AppCompatActivity() {

    override fun onDestroy() {
        super.onDestroy()
        if (isFinishing) {
            releaseDependency()
        }
    }

    protected fun getFeatureApi(featureKey: Class<out ReleasableApi>): ReleasableApi =
        DI.getFeatureApi(featureKey)

    protected fun releaseFeatureApi(featureKey: Class<out ReleasableApi>) {
        DI.releaseFeatureApi(featureKey)
    }

    protected abstract fun releaseDependency()
}
package evgenii.goncharov.econome

import android.app.Application
import evgenii.goncharov.econome.di_core.engine.DI
import evgenii.goncharov.econome.initializer.FeatureHolderInitializerImpl

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDi()
    }

    private fun initDi() {
        DI.initialize(
            featureHolderInitializer = FeatureHolderInitializerImpl(),
            globalHolderInitializer =
        )
    }
}
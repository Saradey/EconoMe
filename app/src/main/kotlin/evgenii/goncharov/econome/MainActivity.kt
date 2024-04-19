package evgenii.goncharov.econome

import android.os.Bundle
import androidx.activity.viewModels
import evgenii.goncharov.econome.di.contracts.MainActivityApi
import evgenii.goncharov.econome.di.contracts.MainActivityInternal
import evgenii.goncharov.econome.di_core.CoreActivity
import evgenii.goncharov.econome.navigation.MainNavigator

class MainActivity : CoreActivity() {

    private val dependency: MainActivityInternal by lazy {
        getFeatureApi(MainActivityApi::class.java) as MainActivityInternal
    }
    private val globalNavigatorHolder = dependency.provideGlobalNavigatorHolder()
    private val mainNavigator: MainNavigator = MainNavigator(this)
    private val viewModel: MainActivityViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        globalNavigatorHolder.setNavigator(mainNavigator)
    }

    override fun onPause() {
        globalNavigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun releaseDependency() {
        releaseFeatureApi(MainActivityApi::class.java)
    }
}

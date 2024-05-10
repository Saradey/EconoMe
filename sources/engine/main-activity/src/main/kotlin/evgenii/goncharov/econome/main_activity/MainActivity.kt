package evgenii.goncharov.econome.main_activity

import android.os.Bundle
import androidx.activity.viewModels
import evgenii.goncharov.econome.di_core.CoreActivity
import evgenii.goncharov.econome.main_activity.di.contracts.MainActivityApi
import evgenii.goncharov.econome.main_activity.di.contracts.MainActivityInternal
import evgenii.goncharov.econome.main_activity.navigation.MainNavigator
import evgenii.goncharov.econome.main_activity.view.model.MainActivityViewModel

internal class MainActivity : CoreActivity() {

    private val dependency: MainActivityInternal by lazy {
        getFeatureApi(MainActivityApi::class.java) as MainActivityInternal
    }
    private val viewModel: MainActivityViewModel by viewModels {
        dependency.provideViewModelFactory()
    }
    private val globalNavigatorHolder = dependency.provideGlobalNavigatorHolder()
    private val mainNavigator = MainNavigator(this)
    private val onBackPressed = dependency.provideOnBackPressedCallback()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onBackPressedDispatcher.addCallback(this, onBackPressed)
        savedInstanceState ?: viewModel.appStart()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
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

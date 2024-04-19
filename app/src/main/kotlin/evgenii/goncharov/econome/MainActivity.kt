package evgenii.goncharov.econome

import android.os.Bundle
import androidx.activity.viewModels
import evgenii.goncharov.econome.di.contracts.MainActivityApi
import evgenii.goncharov.econome.di.contracts.MainActivityInternal
import evgenii.goncharov.econome.di_core.CoreActivity

class MainActivity : CoreActivity() {

    private val dependency: MainActivityInternal by lazy {
        getFeatureApi(MainActivityApi::class.java) as MainActivityInternal
    }
    private val globalNavigatorHolder = dependency.provideGlobalNavigatorHolder()
    private val viewModel: MainActivityViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel
    }

    override fun releaseDependency() {
        releaseFeatureApi(MainActivityApi::class.java)
    }
}

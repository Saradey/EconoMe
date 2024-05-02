package evgenii.goncharov.econome.main_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.main_api.di.MainApi
import evgenii.goncharov.econome.main_impl.di.contracts.MainInternal
import evgenii.goncharov.econome.main_impl.ui.MainScreen
import evgenii.goncharov.econome.main_impl.view.models.MainViewModel

/**
 * 2. Screen
 */
internal class MainFragment : CoreFragment() {

    private val dependency: MainInternal by lazy {
        getFeatureApi(MainApi::class.java) as MainInternal
    }
    private val viewModel: MainViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() {
        viewModel
        MainScreen()
    }

    override fun releaseDependencies() {
        releaseFeatureApi(MainApi::class.java)
    }

    companion object {

        fun newInstance() = MainFragment()
    }
}
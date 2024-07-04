package evgenii.goncharov.econome.main_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.main_api.dependencies.MainDataRefresher
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
    private val refresher: MainDataRefresher = (dependency as MainApi).provideMainDataRefresher()

    override fun onResume() {
        super.onResume()
        refresher.refreshListener = viewModel::refreshData
    }

    override fun onPause() {
        super.onPause()
        refresher.refreshListener = null
    }

    @Composable
    override fun InitContent() = MainScreen(
        viewModel = viewModel
    )

    override fun releaseDependencies() {
        releaseFeatureApi(MainApi::class.java)
    }

    companion object {

        fun newInstance() = MainFragment()
    }
}
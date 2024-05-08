package evgenii.goncharov.econome.spending_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.spending_api.di.SpendingInfoApi
import evgenii.goncharov.econome.spending_impl.di.contracts.SpendingInfoInternal
import evgenii.goncharov.econome.spending_impl.ui.SpendingInfoScreen
import evgenii.goncharov.econome.spending_impl.view.models.SpendingInfoViewModel

/**
 * 5. Screen
 */
internal class SpendingInfoFragment : CoreFragment() {

    private val dependency: SpendingInfoInternal by lazy {
        getFeatureApi(SpendingInfoApi::class.java) as SpendingInfoInternal
    }
    private val viewModel: SpendingInfoViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = SpendingInfoScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(SpendingInfoApi::class.java)
    }

    companion object {

        fun newInstance() = SpendingInfoFragment()
    }
}
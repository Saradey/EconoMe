package evgenii.goncharov.econome.main_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreDialogFragment
import evgenii.goncharov.econome.di_core.extensions.getFeatureApi
import evgenii.goncharov.econome.di_core.extensions.releaseFeatureApi
import evgenii.goncharov.econome.main_api.di.SpendingLimitApi
import evgenii.goncharov.econome.main_impl.di.contracts.SpendingLimitInternal
import evgenii.goncharov.econome.main_impl.ui.SpendingLimitScreen
import evgenii.goncharov.econome.main_impl.view.models.SpendingLimitViewModel

/**
 * 10. Screen
 */
internal class SpendingLimitDialogFragment : CoreDialogFragment() {

    private val dependency: SpendingLimitInternal by lazy {
        getFeatureApi(SpendingLimitApi::class.java) as SpendingLimitInternal
    }
    private val viewModel: SpendingLimitViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = SpendingLimitScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(SpendingLimitApi::class.java)
    }

    companion object {

        fun newInstance() = SpendingLimitDialogFragment()
    }
}
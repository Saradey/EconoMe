package evgenii.goncharov.econome.spending_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.spending_api.di.AddSpendingApi
import evgenii.goncharov.econome.spending_impl.di.contracts.AddSpendingInternal
import evgenii.goncharov.econome.spending_impl.ui.AddSpendingScreen
import evgenii.goncharov.econome.spending_impl.view.models.AddSpendingViewModel

/**
 * 3. Screen
 */
internal class AddSpendingFragment : CoreFragment() {

    private val dependency: AddSpendingInternal by lazy {
        getFeatureApi(AddSpendingApi::class.java) as AddSpendingInternal
    }
    private val viewModel: AddSpendingViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = AddSpendingScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(AddSpendingApi::class.java)
    }

    companion object {

        fun newInstance() = AddSpendingFragment()
    }
}
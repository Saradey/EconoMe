package evgenii.goncharov.econome.all_spending_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.all_spending_api.di.AllSpendingApi
import evgenii.goncharov.econome.all_spending_impl.di.contracts.AllSpendingInternal
import evgenii.goncharov.econome.all_spending_impl.ui.AllSpendingScreen
import evgenii.goncharov.econome.all_spending_impl.view.models.AllSpendingViewModel
import evgenii.goncharov.econome.di_core.CoreFragment

/**
 * 6. Screen
 */
internal class AllSpendingFragment : CoreFragment() {

    private val dependency: AllSpendingInternal by lazy {
        getFeatureApi(AllSpendingApi::class.java) as AllSpendingInternal
    }
    private val viewModel: AllSpendingViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = AllSpendingScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(AllSpendingApi::class.java)
    }

    companion object {

        fun newInstance() = AllSpendingFragment()
    }
}
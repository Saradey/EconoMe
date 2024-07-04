package evgenii.goncharov.econome.spending_impl.fragments

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import evgenii.goncharov.econome.common.ui.SystemEvent
import evgenii.goncharov.econome.di_core.CoreBottomSheetFragment
import evgenii.goncharov.econome.di_core.extensions.getFeatureApi
import evgenii.goncharov.econome.di_core.extensions.releaseFeatureApi
import evgenii.goncharov.econome.spending_api.di.AddSpendingApi
import evgenii.goncharov.econome.spending_impl.di.contracts.AddSpendingInternal
import evgenii.goncharov.econome.spending_impl.ui.AddSpendingScreen
import evgenii.goncharov.econome.spending_impl.view.models.AddSpendingViewModel
import kotlinx.coroutines.launch

/**
 * 3. Screen
 */
internal class AddSpendingDialogFragment : CoreBottomSheetFragment() {

    private val dependency: AddSpendingInternal by lazy {
        getFeatureApi(AddSpendingApi::class.java) as AddSpendingInternal
    }
    private val viewModel: AddSpendingViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch { viewModel.systemEvent.collect { event -> handleSystemEvent(event) } }
    }

    @Composable
    override fun InitContent() = AddSpendingScreen(viewModel)

    override fun releaseDependencies() {
        releaseFeatureApi(AddSpendingApi::class.java)
    }

    private fun handleSystemEvent(event: SystemEvent) {
        when (event) {
            SystemEvent.DismissDialog -> dismiss()
            else -> Unit
        }
    }

    companion object {

        fun newInstance() = AddSpendingDialogFragment()
    }
}
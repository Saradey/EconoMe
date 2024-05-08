package evgenii.goncharov.econome.bank_accounts_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.bank_accounts_api.di.AddStateAccountApi
import evgenii.goncharov.econome.bank_accounts_impl.di.contracts.AddStateAccountInternal
import evgenii.goncharov.econome.bank_accounts_impl.ui.AddStateAccountScreen
import evgenii.goncharov.econome.bank_accounts_impl.view.models.AddStateAccountViewModel
import evgenii.goncharov.econome.di_core.CoreBottomSheetFragment

/**
 * 8. Screen
 */
internal class AddStateAccountBottomSheetFragment : CoreBottomSheetFragment() {

    private val dependency: AddStateAccountInternal by lazy {
        getFeatureApi(AddStateAccountApi::class.java) as AddStateAccountInternal
    }
    private val viewModel: AddStateAccountViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = AddStateAccountScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(AddStateAccountApi::class.java)
    }

    companion object {

        fun newInstance() = AddStateAccountBottomSheetFragment()
    }
}
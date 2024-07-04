package evgenii.goncharov.econome.bank_accounts_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.bank_accounts_api.di.AddPatternAccountApi
import evgenii.goncharov.econome.bank_accounts_impl.di.contracts.AddPatternAccountInternal
import evgenii.goncharov.econome.bank_accounts_impl.ui.AddPatternAccountScreen
import evgenii.goncharov.econome.bank_accounts_impl.view.models.AddPatternAccountViewModel
import evgenii.goncharov.econome.di_core.CoreBottomSheetFragment
import evgenii.goncharov.econome.di_core.extensions.getFeatureApi

/**
 * 14. Screen
 */
internal class AddPatternAccountBottomSheetFragment : CoreBottomSheetFragment(){

    private val dependency: AddPatternAccountInternal by lazy {
        getFeatureApi(AddPatternAccountApi::class.java) as AddPatternAccountInternal
    }
    private val viewModel: AddPatternAccountViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = AddPatternAccountScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(AddPatternAccountApi::class.java)
    }

    companion object {

        fun newInstance() = AddPatternAccountBottomSheetFragment()
    }
}
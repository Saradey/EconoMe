package evgenii.goncharov.econome.bank_accounts_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.bank_accounts_api.di.BankAccountsApi
import evgenii.goncharov.econome.bank_accounts_impl.di.contracts.BankAccountsInternal
import evgenii.goncharov.econome.bank_accounts_impl.ui.BankAccountsScreen
import evgenii.goncharov.econome.bank_accounts_impl.view.models.BankAccountsViewModel
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.di_core.extensions.getFeatureApi
import evgenii.goncharov.econome.di_core.extensions.releaseFeatureApi

/**
 * 7. Screen
 */
internal class BankAccountsFragment : CoreFragment() {

    private val dependency: BankAccountsInternal by lazy {
        getFeatureApi(BankAccountsApi::class.java) as BankAccountsInternal
    }
    private val viewModel: BankAccountsViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = BankAccountsScreen(
        goToAddStateAccount = viewModel::navigateToAddStateAccount,
        goToAddPatternAccount = viewModel::navigateToAddPatternAccount
    )

    override fun releaseDependencies() {
        releaseFeatureApi(BankAccountsApi::class.java)
    }

    companion object {

        fun newInstance() = BankAccountsFragment()
    }
}
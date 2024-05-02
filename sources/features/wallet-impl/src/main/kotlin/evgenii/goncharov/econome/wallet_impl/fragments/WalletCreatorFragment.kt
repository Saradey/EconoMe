package evgenii.goncharov.econome.wallet_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.wallet_api.di.WalletCreatorApi
import evgenii.goncharov.econome.wallet_impl.di.contracts.WalletCreatorInternal
import evgenii.goncharov.econome.wallet_impl.ui.WalletCreatorScreen
import evgenii.goncharov.econome.wallet_impl.view.models.WalletCreatorViewModel

internal class WalletCreatorFragment : CoreFragment() {

    private val dependency: WalletCreatorInternal by lazy {
        getFeatureApi(WalletCreatorApi::class.java) as WalletCreatorInternal
    }
    private val viewModel: WalletCreatorViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = WalletCreatorScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(WalletCreatorApi::class.java)
    }

    companion object {

        fun newInstance() = WalletCreatorFragment()
    }
}
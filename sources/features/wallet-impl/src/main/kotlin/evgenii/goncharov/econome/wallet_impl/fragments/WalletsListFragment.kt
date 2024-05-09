package evgenii.goncharov.econome.wallet_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.wallet_api.di.WalletsListApi
import evgenii.goncharov.econome.wallet_impl.di.contracts.WalletsListInternal
import evgenii.goncharov.econome.wallet_impl.ui.WalletsListScreen
import evgenii.goncharov.econome.wallet_impl.view.models.WalletsListViewModel

/**
 * 16. Screen
 */
internal class WalletsListFragment : CoreFragment() {

    private val dependency: WalletsListInternal by lazy {
        getFeatureApi(WalletsListApi::class.java) as WalletsListInternal
    }
    private val viewModel: WalletsListViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = WalletsListScreen(viewModel::navigateWalletCreator)

    override fun releaseDependencies() {
        releaseFeatureApi(WalletsListApi::class.java)
    }

    companion object {

        fun newInstance() = WalletsListFragment()
    }
}
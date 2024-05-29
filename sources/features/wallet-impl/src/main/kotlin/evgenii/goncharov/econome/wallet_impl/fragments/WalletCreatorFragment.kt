package evgenii.goncharov.econome.wallet_impl.fragments

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.wallet_api.di.WalletCreatorApi
import evgenii.goncharov.econome.wallet_impl.di.contracts.WalletCreatorInternal
import evgenii.goncharov.econome.wallet_impl.ui.WalletCreatorScreen
import evgenii.goncharov.econome.wallet_impl.view.models.WalletCreatorViewModel

/**
 * 4. Screen
 */
internal class WalletCreatorFragment : CoreFragment() {

    private val dependency: WalletCreatorInternal by lazy {
        getFeatureApi(WalletCreatorApi::class.java) as WalletCreatorInternal
    }
    private val viewModel: WalletCreatorViewModel by viewModels {
        dependency.provideViewModelFactory()
    }
    val userUuid : String by lazy { requireArguments() }

    @Composable
    override fun InitContent() = WalletCreatorScreen(viewModel::goToMainBottomNavigation)

    override fun releaseDependencies() {
        releaseFeatureApi(WalletCreatorApi::class.java)
    }

    companion object {

        private const val USER_UUID_ARG = "USER_UUID_ARG"

        fun newInstance(userUuid: String): Fragment {
            val args = Bundle()
            args.putString(USER_UUID_ARG, userUuid)
            return WalletCreatorFragment().apply {
                arguments = args
            }
        }
    }
}
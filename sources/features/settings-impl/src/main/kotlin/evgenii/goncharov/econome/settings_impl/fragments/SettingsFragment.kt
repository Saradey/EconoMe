package evgenii.goncharov.econome.settings_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.di_core.extensions.getFeatureApi
import evgenii.goncharov.econome.di_core.extensions.releaseFeatureApi
import evgenii.goncharov.econome.settings_api.di.SettingsApi
import evgenii.goncharov.econome.settings_impl.di.contracts.SettingsInternal
import evgenii.goncharov.econome.settings_impl.ui.SettingsScreen
import evgenii.goncharov.econome.settings_impl.view.models.SettingsViewModel

/**
 * 9. Screen
 */
internal class SettingsFragment : CoreFragment() {

    private val dependency: SettingsInternal by lazy {
        getFeatureApi(SettingsApi::class.java) as SettingsInternal
    }
    private val viewModel: SettingsViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = SettingsScreen(
        goToUserCreator = viewModel::navigateUserCreator,
        goToUserChoosing = viewModel::navigateUserChoosing,
        goToWalletCreator = viewModel::navigateWalletCreator,
        goToAllWallet = viewModel::navigateAllWallet,
        goToAllCategories = viewModel::navigateAllCategories,
        goToAddProduct = viewModel::navigateAddProduct,
        goToAddSubProduct = viewModel::navigateAddSubProduct
    )

    override fun releaseDependencies() {
        releaseFeatureApi(SettingsApi::class.java)
    }

    companion object {

        fun newInstance() = SettingsFragment()
    }
}
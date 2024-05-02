package evgenii.goncharov.econome.user_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.user_api.di.UserCreatorApi
import evgenii.goncharov.econome.user_impl.di.contracts.UserCreatorInternal
import evgenii.goncharov.econome.user_impl.ui.UserCreatorScreen
import evgenii.goncharov.econome.user_impl.view.models.UserCreatorViewModel

/**
 *  0. Screen
 */
internal class UserCreatorFragment : CoreFragment() {

    private val dependency: UserCreatorInternal by lazy {
        getFeatureApi(UserCreatorApi::class.java) as UserCreatorInternal
    }
    private val viewModel: UserCreatorViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() {
        viewModel
        UserCreatorScreen(viewModel::goToWalletCreator)
    }

    override fun releaseDependencies() {
        releaseFeatureApi(UserCreatorApi::class.java)
    }

    companion object {

        fun newInstance() = UserCreatorFragment()
    }
}
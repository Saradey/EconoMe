package evgenii.goncharov.econome.user_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.user_api.di.UserChoosingApi
import evgenii.goncharov.econome.user_impl.di.contracts.UserChoosingInternal
import evgenii.goncharov.econome.user_impl.ui.UserChoosingScreen
import evgenii.goncharov.econome.user_impl.view.models.UserChoosingViewModel

/**
 * 15. Screen
 */
internal class UserChoosingFragment : CoreFragment() {

    private val dependency: UserChoosingInternal by lazy {
        getFeatureApi(UserChoosingApi::class.java) as UserChoosingInternal
    }
    private val viewModel: UserChoosingViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() {
        viewModel
        UserChoosingScreen()
    }

    override fun releaseDependencies() {
        releaseFeatureApi(UserChoosingApi::class.java)
    }

    companion object {

        fun newInstance() = UserChoosingFragment()
    }
}
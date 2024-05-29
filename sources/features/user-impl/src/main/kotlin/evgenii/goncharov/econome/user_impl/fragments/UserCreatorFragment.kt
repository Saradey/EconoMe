package evgenii.goncharov.econome.user_impl.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import evgenii.goncharov.econome.common.ui.SystemEvent
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.user_api.di.UserCreatorApi
import evgenii.goncharov.econome.user_impl.di.contracts.UserCreatorInternal
import evgenii.goncharov.econome.user_impl.ui.UserCreatorScreen
import evgenii.goncharov.econome.user_impl.view.models.UserCreatorViewModel
import kotlinx.coroutines.launch

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
    private val oneTapResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartIntentSenderForResult()
    ) { result ->
        viewModel.userCreated()
    }

    @Composable
    override fun InitContent() = UserCreatorScreen(
        state = viewModel.uiState,
        goToWalletCreatorListener = { viewModel.goToWalletCreator(oneTapResultLauncher) },
        input = viewModel::inputUserName
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch { viewModel.systemEvent.collect { event -> handleSystemEvent(event) } }
    }

    private fun handleSystemEvent(event: SystemEvent) {
        when (event) {
            is SystemEvent.ShowToast -> showErrorRegToast(event.messageToast)
            else -> Unit
        }
    }

    private fun showErrorRegToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun releaseDependencies() {
        releaseFeatureApi(UserCreatorApi::class.java)
    }

    companion object {

        fun newInstance() = UserCreatorFragment()
    }
}
package evgenii.goncharov.econome.user_impl.view.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.user_impl.models.UserCreatorUiState
import evgenii.goncharov.econome.user_impl.use.cases.UserValidateNameUseCase
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher
import javax.inject.Inject

internal class UserCreatorViewModel @Inject constructor(
    private val walletLauncher: WalletLauncher,
    private val userValidateNameUseCase: UserValidateNameUseCase
) : ViewModel() {

    private val _uiState: MutableState<UserCreatorUiState> = mutableStateOf(
        UserCreatorUiState.Content(userNameInputText = "")
    )
    val uiState: State<UserCreatorUiState> = _uiState

    fun goToWalletCreator() {
        walletLauncher.launchReplaceWalletCreator()
    }

    fun inputUserName(userName: String) {
        val oldUserName = (_uiState.value as? UserCreatorUiState.Content)?.userNameInputText
        if (userValidateNameUseCase(userName) || userValidateNameUseCase(oldUserName)) {

        }
    }
}
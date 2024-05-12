package evgenii.goncharov.econome.user_impl.view.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.user_impl.models.UserCreatorUiState
import evgenii.goncharov.econome.user_impl.models.UserStatusModel
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
        when (userValidateNameUseCase(userName)) {
            is UserStatusModel.IncorrectInput -> {
                _uiState.value = createErrorInputUserName(userName, "Ошибка: разрешены [a-zA-z]")
            }

            is UserStatusModel.Success -> {
                _uiState.value = UserCreatorUiState.Content(userNameInputText = userName)
            }

            is UserStatusModel.EmptyInput -> {
                _uiState.value = createErrorInputUserName(userName, "Ошибка: пустая строка")
            }
        }
    }

    private fun createErrorInputUserName(
        inputText: String,
        errorMessage: String
    ): UserCreatorUiState.ErrorInputUserName {
        return UserCreatorUiState.ErrorInputUserName(
            userNameInputText = inputText,
            errorMessage = errorMessage
        )
    }
}
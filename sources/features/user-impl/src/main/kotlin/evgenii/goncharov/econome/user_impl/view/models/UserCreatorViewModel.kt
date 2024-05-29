package evgenii.goncharov.econome.user_impl.view.models

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.common_provider.managers.AuthManager
import evgenii.goncharov.econome.common_provider.managers.ResourceManager
import evgenii.goncharov.econome.user_impl.R
import evgenii.goncharov.econome.user_impl.models.UserCreatorUiState
import evgenii.goncharov.econome.user_impl.models.UserStatusModel
import evgenii.goncharov.econome.user_impl.use.cases.UserValidateNameUseCase
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher
import javax.inject.Inject

internal class UserCreatorViewModel @Inject constructor(
    private val walletLauncher: WalletLauncher,
    private val userValidateNameUseCase: UserValidateNameUseCase,
    private val resourceManager: ResourceManager,
    private val authManager: AuthManager
) : ViewModel() {

    private val _uiState: MutableState<UserCreatorUiState> = mutableStateOf(
        UserCreatorUiState.Content(userNameInputText = "")
    )
    val uiState: State<UserCreatorUiState> = _uiState

    fun goToWalletCreator(resultLauncher: ActivityResultLauncher<IntentSenderRequest>) {
        val userNameInputText = getUserInputText()
        val validate = userValidateNameUseCase(userNameInputText)
        when (validate) {
            is UserStatusModel.IncorrectInput -> {
                _uiState.value = createErrorInputUserName(
                    userNameInputText,
                    resourceManager.getString(R.string.error_message_symbol)
                )
            }

            is UserStatusModel.EmptyInput -> {
                _uiState.value = createErrorInputUserName(
                    userNameInputText,
                    resourceManager.getString(R.string.error_message_empty)
                )
            }

            is UserStatusModel.Success -> {
                authManager.authUser(resultLauncher)
            }
        }
    }

    fun inputUserName(userName: String) {
        val validate = userValidateNameUseCase(userName)
        when (validate) {
            is UserStatusModel.IncorrectInput -> {
                _uiState.value = createErrorInputUserName(
                    userName,
                    resourceManager.getString(R.string.error_message_symbol)
                )
            }

            is UserStatusModel.Success, is UserStatusModel.EmptyInput -> {
                _uiState.value = UserCreatorUiState.Content(userNameInputText = userName)
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

    private fun getUserInputText(): String {
        return when (val state: UserCreatorUiState = _uiState.value) {
            is UserCreatorUiState.Content -> state.userNameInputText
            is UserCreatorUiState.ErrorInputUserName -> state.userNameInputText
        }
    }
}
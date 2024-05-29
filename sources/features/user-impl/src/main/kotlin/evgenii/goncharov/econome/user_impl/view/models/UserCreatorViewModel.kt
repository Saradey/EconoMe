package evgenii.goncharov.econome.user_impl.view.models

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import evgenii.goncharov.econome.common.ui.SystemEvent
import evgenii.goncharov.econome.common_provider.managers.AuthManager
import evgenii.goncharov.econome.common_provider.managers.ResourceManager
import evgenii.goncharov.econome.core_database_api.data.stores.UserDataStore
import evgenii.goncharov.econome.core_database_api.dto.UserDto
import evgenii.goncharov.econome.user_impl.R
import evgenii.goncharov.econome.user_impl.models.UserCreatorUiState
import evgenii.goncharov.econome.user_impl.models.UserStatusModel
import evgenii.goncharov.econome.user_impl.use.cases.UserValidateNameUseCase
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class UserCreatorViewModel @Inject constructor(
    private val walletLauncher: WalletLauncher,
    private val userValidateNameUseCase: UserValidateNameUseCase,
    private val resourceManager: ResourceManager,
    private val authManager: AuthManager,
    private val userDataStore: UserDataStore
) : ViewModel() {

    private val _uiState: MutableState<UserCreatorUiState> = mutableStateOf(
        UserCreatorUiState.Content(userNameInputText = "")
    )
    val uiState: State<UserCreatorUiState> = _uiState
    private val _systemEvent: MutableStateFlow<SystemEvent> = MutableStateFlow(
        SystemEvent.InitialState
    )
    val systemEvent: StateFlow<SystemEvent> = _systemEvent

    fun goToWalletCreator(resultLauncher: ActivityResultLauncher<IntentSenderRequest>) {
        val userNameInputText = _uiState.value.userNameInputText
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
                authManager.authUser(resultLauncher, ::failReg)
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

    fun userCreated(userId: String) {
        val userInputName = _uiState.value.userNameInputText
        viewModelScope.launch {
            saveUser(userId, userInputName)
            walletLauncher.launchReplaceWalletCreator()
        }
    }

    private fun createErrorInputUserName(
        inputText: String,
        errorMessage: String
    ): UserCreatorUiState.ErrorInputUserName {
        return UserCreatorUiState.ErrorInputUserName(
            userNameInputText = inputText,
            errorInputMessage = errorMessage
        )
    }

    private fun failReg() {
        _systemEvent.value = SystemEvent.ShowToast(
            messageToast = resourceManager.getString(R.string.error_message_reg)
        )
    }

    private suspend fun saveUser(
        userId: String,
        userInputName: String
    ) = withContext(Dispatchers.IO) {
        userDataStore.saveNewUser(
            UserDto(
                uuid = userId,
                userName = userInputName
            )
        )
    }
}
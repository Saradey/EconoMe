package evgenii.goncharov.econome.user_impl.view.models

import android.content.Intent
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
import evgenii.goncharov.econome.current_user.repositories.CurrentUserRepository
import evgenii.goncharov.econome.user_impl.R
import evgenii.goncharov.econome.user_impl.models.UserCreatorUiState
import evgenii.goncharov.econome.user_impl.models.UserStatusModel
import evgenii.goncharov.econome.user_impl.repositories.UserCreatorRepository
import evgenii.goncharov.econome.user_impl.use.cases.UserValidateNameUseCase
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.UUID
import javax.inject.Inject

internal class UserCreatorViewModel @Inject constructor(
    private val walletLauncher: WalletLauncher,
    private val userValidateNameUseCase: UserValidateNameUseCase,
    private val resourceManager: ResourceManager,
    private val authManager: AuthManager,
    private val userCreatorRepository: UserCreatorRepository,
    private val currentUserRepository: CurrentUserRepository
) : ViewModel() {

    private val _uiState: MutableState<UserCreatorUiState> = mutableStateOf(
        UserCreatorUiState()
    )
    val uiState: State<UserCreatorUiState> = _uiState
    private val _systemEvent: MutableStateFlow<SystemEvent> = MutableStateFlow(
        SystemEvent.InitialState
    )
    val systemEvent: StateFlow<SystemEvent> = _systemEvent

    fun createAccountWithGoogle(resultLauncher: ActivityResultLauncher<IntentSenderRequest>) {
        val userNameInputText = _uiState.value.userNameInputText
        val validate = userValidateNameUseCase(userNameInputText)
        when (validate) {
            is UserStatusModel.IncorrectInput -> makeErrorSymbolState()
            is UserStatusModel.EmptyInput -> makeErrorEmptyState()
            is UserStatusModel.Success -> authManager.authUser(resultLauncher, ::failReg)
        }
    }

    fun inputUserName(userName: String) {
        val trimUserName = userName.trim()
        val validate = userValidateNameUseCase(trimUserName)
        when (validate) {
            is UserStatusModel.IncorrectInput -> makeErrorSymbolState(trimUserName)
            is UserStatusModel.Success, is UserStatusModel.EmptyInput -> {
                _uiState.value = _uiState.value.copy(
                    userNameInputText = trimUserName,
                    errorInputMessage = null
                )
            }
        }
    }

    fun userCreated(intent: Intent) {
        viewModelScope.launch(CoroutineExceptionHandler { _, _ ->
            failReg()
        }) {
            val userId = authManager.getSignInCredentialFromIntent(intent)
            val userInputName = _uiState.value.userNameInputText
            saveUser(userId, userInputName)
            currentUserRepository.setUserId(userId)
            walletLauncher.launchReplaceWalletCreator(userId)
        }
    }

    fun createAccountWithUuid() {
        viewModelScope.launch {
            val userInputName = _uiState.value.userNameInputText
            val validate = userValidateNameUseCase(userInputName)
            when (validate) {
                is UserStatusModel.IncorrectInput -> makeErrorSymbolState()
                is UserStatusModel.EmptyInput -> makeErrorEmptyState()
                is UserStatusModel.Success -> generateUuid(userInputName)
            }
        }
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
        userCreatorRepository.saveNewUser(userId, userInputName)
    }

    private fun makeErrorSymbolState(userNameInputText: String) {
        _uiState.value = _uiState.value.copy(
            userNameInputText = userNameInputText,
            errorInputMessage = resourceManager.getString(R.string.error_message_symbol)
        )
    }

    private fun makeErrorSymbolState() {
        _uiState.value = _uiState.value.copy(
            errorInputMessage = resourceManager.getString(R.string.error_message_symbol)
        )
    }

    private fun makeErrorEmptyState() {
        _uiState.value = _uiState.value.copy(
            errorInputMessage = resourceManager.getString(R.string.error_message_empty)
        )
    }

    private suspend fun generateUuid(userInputName: String) {
        val userUuid = UUID.randomUUID().toString()
        saveUser(userUuid, userInputName)
        walletLauncher.launchReplaceWalletCreator(userUuid)
    }
}
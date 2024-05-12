package evgenii.goncharov.econome.user_impl.models

internal sealed class UserCreatorUiState {

    data class Content(
        val userNameInputText: String
    ) : UserCreatorUiState()

    data class ErrorInputUserName(
        val userNameInputText: String,
        val errorMessage: String
    ) : UserCreatorUiState()
}
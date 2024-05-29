package evgenii.goncharov.econome.user_impl.models

internal sealed class UserCreatorUiState(
    open val userNameInputText: String,
    open val errorInputMessage: String = ""
) {

    data class Content(
        override val userNameInputText: String
    ) : UserCreatorUiState(userNameInputText)

    data class ErrorInputUserName(
        override val userNameInputText: String,
        override val errorInputMessage: String
    ) : UserCreatorUiState(userNameInputText)
}
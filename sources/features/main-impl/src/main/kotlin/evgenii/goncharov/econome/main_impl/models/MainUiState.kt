package evgenii.goncharov.econome.main_impl.models

internal sealed class MainUiState {

    data object InitialState : MainUiState()

    data class Content(
        val currentUser: CurrentUserModel
    ) : MainUiState()
}
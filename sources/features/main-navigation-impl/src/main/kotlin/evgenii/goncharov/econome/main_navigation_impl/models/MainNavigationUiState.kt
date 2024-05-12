package evgenii.goncharov.econome.main_navigation_impl.models

internal sealed class MainNavigationUiState {

    data class Content(
        val mainMenuItems: List<MainBottomNavItem>
    ) : MainNavigationUiState()
}
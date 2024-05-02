package evgenii.goncharov.econome.main_navigation_impl.models

internal sealed class MainNavigationState {

    data class Content(
        val mainMenuItems: List<MainBottomNavItem>
    ) : MainNavigationState()
}
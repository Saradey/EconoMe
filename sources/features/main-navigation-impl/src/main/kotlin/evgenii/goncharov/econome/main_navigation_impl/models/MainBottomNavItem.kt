package evgenii.goncharov.econome.main_navigation_impl.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import evgenii.goncharov.econome.main_navigation_impl.utils.NavigationTabs

internal data class MainBottomNavItem(
    val tab: NavigationTabs,
    val isSelected: Boolean = false,
    @StringRes val title: Int,
    @DrawableRes val icon: Int
)
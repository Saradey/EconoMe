package evgenii.goncharov.econome.main_navigation_impl.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

internal data class MainBottomNavItem(
    val name: String,
    val isSelected: Boolean = false,
    @StringRes val title: Int,
    @DrawableRes val icon: Int
)
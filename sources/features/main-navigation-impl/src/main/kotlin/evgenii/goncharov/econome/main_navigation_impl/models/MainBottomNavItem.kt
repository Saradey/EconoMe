package evgenii.goncharov.econome.main_navigation_impl.models

import androidx.annotation.DrawableRes

internal data class MainBottomNavItem(
    var title: String,
    @DrawableRes var icon: Int
)
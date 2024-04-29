package evgenii.goncharov.econome.main_navigation_impl.utils

import evgenii.goncharov.econome.main_navigation_impl.R
import evgenii.goncharov.econome.main_navigation_impl.models.MainBottomNavItem
import evgenii.goncharov.econome.ui_kit.UiKitString

internal fun createBottomNavigationItems(): List<MainBottomNavItem> {
    return listOf(
        MainBottomNavItem(
            name = "main",
            title = R.string.item_1_main,
            icon = UiKitString.icon_stub,
            isSelected = true
        ),
        MainBottomNavItem(
            name = "all_spending",
            title = R.string.item_2_all_spending,
            icon = UiKitString.icon_stub
        ),
        MainBottomNavItem(
            name = "all_spending_analysis",
            title = R.string.item_3_all_spending_analysis,
            icon = UiKitString.icon_stub
        ),
        MainBottomNavItem(
            name = "account_state",
            title = R.string.item_4_account_state,
            icon = UiKitString.icon_stub
        )
    )
}
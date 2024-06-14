package evgenii.goncharov.econome.main_navigation_impl.utils

import evgenii.goncharov.econome.main_navigation_impl.R
import evgenii.goncharov.econome.main_navigation_impl.models.MainBottomNavItem
import evgenii.goncharov.econome.ui_kit.UiKitDrawable

internal fun createBottomNavigationItems(): List<MainBottomNavItem> {
    return listOf(
        MainBottomNavItem(
            tab = NavigationTabs.Main,
            title = R.string.item_1_main,
            icon = UiKitDrawable.icon_stub,
            isSelected = true
        ),
        MainBottomNavItem(
            tab = NavigationTabs.AllSpending,
            title = R.string.item_2_all_spending,
            icon = UiKitDrawable.icon_stub
        ),
        MainBottomNavItem(
            tab = NavigationTabs.AllSpendingAnalysis,
            title = R.string.item_3_all_spending_analysis,
            icon = UiKitDrawable.icon_stub
        ),
        MainBottomNavItem(
            tab = NavigationTabs.AccountState,
            title = R.string.item_4_account_state,
            icon = UiKitDrawable.icon_stub
        )
    )
}
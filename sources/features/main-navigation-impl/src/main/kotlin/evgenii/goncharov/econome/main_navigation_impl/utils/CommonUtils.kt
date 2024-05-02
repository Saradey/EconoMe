package evgenii.goncharov.econome.main_navigation_impl.utils

import evgenii.goncharov.econome.navigation.navigation.BACKSTACK_NAME_ACCOUNT_STATE
import evgenii.goncharov.econome.navigation.navigation.BACKSTACK_NAME_ALL_SPENDING
import evgenii.goncharov.econome.navigation.navigation.BACKSTACK_NAME_ALL_SPENDING_ANALYSIS
import evgenii.goncharov.econome.navigation.navigation.BACKSTACK_NAME_MAIN

internal fun String.toNavigationTabs(): NavigationTabs {
    return when {
        this == BACKSTACK_NAME_MAIN -> NavigationTabs.Main
        this == BACKSTACK_NAME_ALL_SPENDING -> NavigationTabs.AllSpending
        this == BACKSTACK_NAME_ALL_SPENDING_ANALYSIS -> NavigationTabs.AllSpendingAnalysis
        this == BACKSTACK_NAME_ACCOUNT_STATE -> NavigationTabs.AccountState
        else -> NavigationTabs.TabNothing
    }
}
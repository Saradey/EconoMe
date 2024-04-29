package evgenii.goncharov.econome.main_navigation_impl.utils

internal sealed class NavigationTabs {

    data object Main : NavigationTabs()

    data object AllSpending : NavigationTabs()

    data object AllSpendingAnalysis : NavigationTabs()

    data object AccountState : NavigationTabs()
}
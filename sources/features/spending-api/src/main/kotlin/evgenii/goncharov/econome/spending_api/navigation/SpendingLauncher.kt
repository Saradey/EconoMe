package evgenii.goncharov.econome.spending_api.navigation

import evgenii.goncharov.econome.di_core.contracts.BaseLauncher

public interface SpendingLauncher : BaseLauncher {

    public fun launchAddSpending()

    public fun launchDeepSpendingInfo(spendingId: Long)
}
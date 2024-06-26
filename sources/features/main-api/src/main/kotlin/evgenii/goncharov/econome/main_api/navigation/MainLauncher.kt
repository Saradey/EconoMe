package evgenii.goncharov.econome.main_api.navigation

import evgenii.goncharov.econome.di_core.contracts.BaseLauncher

public interface MainLauncher : BaseLauncher {

    public fun deepLaunchMain()

    public fun launchSpendingLimit()
}
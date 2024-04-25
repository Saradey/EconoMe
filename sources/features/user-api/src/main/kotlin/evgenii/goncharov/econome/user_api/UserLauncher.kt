package evgenii.goncharov.econome.user_api

import evgenii.goncharov.econome.di_core.contracts.BaseLauncher

public interface UserLauncher: BaseLauncher {

    public fun launchUserCreator()
}
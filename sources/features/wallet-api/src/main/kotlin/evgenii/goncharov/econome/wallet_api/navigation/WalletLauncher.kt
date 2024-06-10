package evgenii.goncharov.econome.wallet_api.navigation

import evgenii.goncharov.econome.di_core.contracts.BaseLauncher

public interface WalletLauncher : BaseLauncher {

    public fun launchReplaceWalletCreator(userUuid: String)

    public fun launchWalletCreator(userUuid: String)

    public fun launchAllWallet()
}
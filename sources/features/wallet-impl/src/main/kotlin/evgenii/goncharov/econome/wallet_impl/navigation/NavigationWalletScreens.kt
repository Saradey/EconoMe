package evgenii.goncharov.econome.wallet_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.wallet_impl.fragments.WalletCreatorFragment
import evgenii.goncharov.econome.wallet_impl.fragments.WalletsListFragment

internal object NavigationWalletScreens {

    fun startWalletCreator(userUuid: String) = FragmentScreen {
        WalletCreatorFragment.newInstance(userUuid)
    }

    fun startWalletsList() = FragmentScreen {
        WalletsListFragment.newInstance()
    }
}
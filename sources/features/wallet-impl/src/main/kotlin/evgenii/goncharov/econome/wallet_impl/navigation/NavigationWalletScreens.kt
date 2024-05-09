package evgenii.goncharov.econome.wallet_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.wallet_impl.fragments.WalletCreatorFragment
import evgenii.goncharov.econome.wallet_impl.fragments.WalletsListFragment

internal object NavigationWalletScreens {

    fun startWalletCreator() = FragmentScreen {
        WalletCreatorFragment.newInstance()
    }

    fun startWalletsList() = FragmentScreen {
        WalletsListFragment.newInstance()
    }
}
package evgenii.goncharov.econome.bank_accounts_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.bank_accounts_impl.fragments.BankAccountsFragment

internal object BankAccountsNavigationScreens {

    fun startBankAccounts() = FragmentScreen {
        BankAccountsFragment.newInstance()
    }
}
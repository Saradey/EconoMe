package evgenii.goncharov.econome.bank_accounts_impl.navigation

import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.bank_accounts_impl.fragments.AddPatternAccountBottomSheetFragment
import evgenii.goncharov.econome.bank_accounts_impl.fragments.AddStateAccountBottomSheetFragment
import evgenii.goncharov.econome.bank_accounts_impl.fragments.BankAccountsFragment
import evgenii.goncharov.econome.navigation.navigation.BACKSTACK_NAME_ACCOUNT_STATE

internal object BankAccountsNavigationScreens {

    fun startDeepBankAccounts() = object : FragmentScreen {
        override val screenKey: String = BACKSTACK_NAME_ACCOUNT_STATE
        override fun createFragment(factory: FragmentFactory) = BankAccountsFragment.newInstance()
    }

    fun startAddStateAccount() = FragmentScreen {
        AddStateAccountBottomSheetFragment.newInstance()
    }

    fun startAddPatternAccount() = FragmentScreen {
        AddPatternAccountBottomSheetFragment.newInstance()
    }
}
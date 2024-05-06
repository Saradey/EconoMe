package evgenii.goncharov.econome.main_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.main_api.navigation.MainLauncher
import evgenii.goncharov.econome.spending_api.navigation.SpendingLauncher
import javax.inject.Inject

internal class MainViewModel @Inject constructor(
    private val spendingLauncher: SpendingLauncher,
    private val mainLauncher: MainLauncher
) : ViewModel() {

    fun goToDialogAddSpending() {
        spendingLauncher.launchAddSpending()
    }

    fun goToSpendingInfo() {
        spendingLauncher.launchDeepSpendingInfo()
    }

    fun goToAddSpendingLimit() {
        mainLauncher.launchSpendingLimit()
    }

    fun goToListShops() {

    }

    fun goToAddCostGoods() {

    }
}
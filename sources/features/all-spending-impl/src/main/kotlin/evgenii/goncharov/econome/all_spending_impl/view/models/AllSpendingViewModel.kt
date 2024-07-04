package evgenii.goncharov.econome.all_spending_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.spending_api.navigation.SpendingLauncher
import javax.inject.Inject

internal class AllSpendingViewModel @Inject constructor(
    private val spendingLauncher: SpendingLauncher
) : ViewModel() {

    fun goToSpendingInfo() {
        // TODO добавить id для перехода
        spendingLauncher.launchSpendingInfo(-1)
    }
}
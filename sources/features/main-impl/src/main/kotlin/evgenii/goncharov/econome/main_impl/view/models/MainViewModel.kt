package evgenii.goncharov.econome.main_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.main_api.navigation.MainLauncher
import evgenii.goncharov.econome.main_impl.interactors.MainInteractor
import evgenii.goncharov.econome.main_impl.models.MainUiState
import evgenii.goncharov.econome.product_cost_analysis_api.navigation.ProductCostAnalysisLauncher
import evgenii.goncharov.econome.spending_api.navigation.SpendingLauncher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

internal class MainViewModel @Inject constructor(
    private val spendingLauncher: SpendingLauncher,
    private val mainLauncher: MainLauncher,
    private val productCostAnalysisLauncher: ProductCostAnalysisLauncher,
    private val mainInteractor: MainInteractor
) : ViewModel() {

    private val _uiState: MutableStateFlow<MainUiState> = MutableStateFlow(MainUiState.InitialState)
    val uiState: Flow<MainUiState> = _uiState

    init {
        mainInteractor.checkParameters()
        initialContent()
    }

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
        productCostAnalysisLauncher.launchDeepListShops()
    }

    fun goToAddCostGoods() {
        productCostAnalysisLauncher.launchDeepAddCostGoods()
    }

    private fun initialContent() {
        val currentUser = mainInteractor.formCurrentUser()
        _uiState.value = MainUiState.Content(
            currentUser = currentUser
        )
    }
}
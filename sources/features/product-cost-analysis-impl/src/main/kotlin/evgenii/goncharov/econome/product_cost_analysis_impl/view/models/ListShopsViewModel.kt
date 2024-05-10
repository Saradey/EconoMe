package evgenii.goncharov.econome.product_cost_analysis_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.product_cost_analysis_api.navigation.ProductCostAnalysisLauncher
import javax.inject.Inject

internal class ListShopsViewModel @Inject constructor(
    private val productCostAnalysisLauncher: ProductCostAnalysisLauncher
) : ViewModel() {

    fun navigateAddCostGoods() {
        productCostAnalysisLauncher.launchDeepAddCostGoods()
    }

    fun navigateAddShop() {
        productCostAnalysisLauncher.launchDeepAddShop()
    }

    fun navigateAnalysisGoodsCost() {

    }
}
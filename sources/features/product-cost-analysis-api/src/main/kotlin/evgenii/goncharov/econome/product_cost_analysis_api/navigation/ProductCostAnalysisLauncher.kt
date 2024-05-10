package evgenii.goncharov.econome.product_cost_analysis_api.navigation

import evgenii.goncharov.econome.di_core.contracts.BaseLauncher

public interface ProductCostAnalysisLauncher : BaseLauncher {

    public fun launchDeepListShops()

    public fun launchDeepAddCostGoods()

    public fun launchDeepAddShop()

    public fun launchAnalysisGoodsCost()
}
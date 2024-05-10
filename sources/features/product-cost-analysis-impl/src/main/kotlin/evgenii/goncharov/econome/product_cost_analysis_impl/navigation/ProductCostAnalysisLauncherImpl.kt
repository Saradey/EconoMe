package evgenii.goncharov.econome.product_cost_analysis_impl.navigation

import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.navigation.utils.DEEP_ROUTER
import evgenii.goncharov.econome.product_cost_analysis_api.navigation.ProductCostAnalysisLauncher
import javax.inject.Inject
import javax.inject.Named

public class ProductCostAnalysisLauncherImpl @Inject constructor(
    @Named(DEEP_ROUTER) private val deepRouter: Router
) : ProductCostAnalysisLauncher {

    override fun launchDeepListShops() {
        deepRouter.navigateTo(ProductCostAnalysisNavigationScreens.startDeepListShops())
    }

    override fun launchDeepAddCostGoods() {
        deepRouter.navigateTo(ProductCostAnalysisNavigationScreens.startDeepAddCostGoods())
    }

    override fun launchDeepAddShop() {
        deepRouter.navigateTo(ProductCostAnalysisNavigationScreens.startDeepAddShop())
    }

    override fun launchAnalysisGoodsCost() {
        deepRouter.navigateTo(ProductCostAnalysisNavigationScreens.startDeepAnalysisGoodsCost())
    }
}
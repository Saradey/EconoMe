package evgenii.goncharov.econome.product_categories_impl.navigation

import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.navigation.utils.GLOBAL_ROUTER
import evgenii.goncharov.econome.product_categories_api.navigation.ProductCategoriesLauncher
import javax.inject.Inject
import javax.inject.Named

public class ProductCategoriesLauncherImpl @Inject constructor(
    @Named(GLOBAL_ROUTER) private val globalRouter: Router
) : ProductCategoriesLauncher {

    override fun launchAddProduct() {
        globalRouter.navigateTo(ProductCategoriesNavigationScreens.startAddProduct())
    }

    override fun launchAddSubProduct() {
        globalRouter.navigateTo(ProductCategoriesNavigationScreens.startAddSubProduct())
    }
}
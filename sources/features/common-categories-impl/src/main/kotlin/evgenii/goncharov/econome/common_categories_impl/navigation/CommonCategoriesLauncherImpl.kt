package evgenii.goncharov.econome.common_categories_impl.navigation

import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.common_categories_api.navigation.CommonCategoriesLauncher
import evgenii.goncharov.econome.navigation.utils.GLOBAL_ROUTER
import javax.inject.Inject
import javax.inject.Named

public class CommonCategoriesLauncherImpl @Inject constructor(
    @Named(GLOBAL_ROUTER) private val globalRouter: Router
) : CommonCategoriesLauncher {

    override fun launchAllCategories() {
        globalRouter.navigateTo(CommonCategoriesNavigationScreen.startAllCategories())
    }

    override fun launchAddCategories() {
        globalRouter.navigateTo(CommonCategoriesNavigationScreen.startAddCategories())
    }
}
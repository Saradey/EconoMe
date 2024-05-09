package evgenii.goncharov.econome.common_categories_api.navigation

import evgenii.goncharov.econome.di_core.contracts.BaseLauncher

public interface CommonCategoriesLauncher : BaseLauncher {

    public fun launchAllCategories()

    public fun launchAddCategories()
}
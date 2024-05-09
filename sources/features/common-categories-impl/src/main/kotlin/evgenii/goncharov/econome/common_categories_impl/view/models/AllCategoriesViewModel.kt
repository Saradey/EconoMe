package evgenii.goncharov.econome.common_categories_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.common_categories_api.navigation.CommonCategoriesLauncher
import javax.inject.Inject

internal class AllCategoriesViewModel @Inject constructor(
    private val commonCategoriesLauncher: CommonCategoriesLauncher
) : ViewModel() {

    fun navigateAddCategories() {
        commonCategoriesLauncher.launchAddCategories()
    }
}
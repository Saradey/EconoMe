package evgenii.goncharov.econome.common_categories_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.common_categories_impl.fragments.AllCategoriesFragment

internal object CommonCategoriesNavigationScreen {

    fun startAllCategories() = FragmentScreen {
        AllCategoriesFragment.newInstance()
    }
}
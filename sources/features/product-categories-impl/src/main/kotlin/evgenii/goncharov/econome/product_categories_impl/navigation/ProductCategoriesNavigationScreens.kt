package evgenii.goncharov.econome.product_categories_impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import evgenii.goncharov.econome.product_categories_impl.fragments.AddProductFragment
import evgenii.goncharov.econome.product_categories_impl.fragments.AddSubProductFragment

internal object ProductCategoriesNavigationScreens {

    fun startAddProduct() = FragmentScreen {
        AddProductFragment.newInstance()
    }

    fun startAddSubProduct() = FragmentScreen {
        AddSubProductFragment.newInstance()
    }
}
package evgenii.goncharov.econome.settings_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.common_categories_api.navigation.CommonCategoriesLauncher
import evgenii.goncharov.econome.product_categories_api.navigation.ProductCategoriesLauncher
import evgenii.goncharov.econome.user_api.navigation.UserLauncher
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher
import javax.inject.Inject

internal class SettingsViewModel @Inject constructor(
    private val userLauncher: UserLauncher,
    private val walletLauncher: WalletLauncher,
    private val commonCategoriesLauncher: CommonCategoriesLauncher,
    private val productCategoriesLauncher: ProductCategoriesLauncher
) : ViewModel() {

    fun navigateUserCreator() {
        userLauncher.launchUserCreator()
    }

    fun navigateUserChoosing() {
        userLauncher.launchUserChoosing()
    }

    fun navigateWalletCreator() {
        walletLauncher.launchWalletCreator()
    }

    fun navigateAllWallet() {
        walletLauncher.launchAllWallet()
    }

    fun navigateAllCategories() {
        commonCategoriesLauncher.launchAllCategories()
    }

    fun navigateAddProduct() {
        productCategoriesLauncher.launchAddProduct()
    }

    fun navigateAddSubProduct() {
        productCategoriesLauncher.launchAddSubProduct()
    }
}
package evgenii.goncharov.econome.user_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import javax.inject.Inject

internal class UserChoosingViewModel @Inject constructor(
    private val mainNavigationLauncher: MainNavigationLauncher
) : ViewModel() {

    fun goToMainBottomNavigationMenu() {
        mainNavigationLauncher.launchMainNavigation()
    }
}
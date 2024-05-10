package evgenii.goncharov.econome.main_activity.view.model

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.main_activity.use.cases.CheckUserUseCase
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import evgenii.goncharov.econome.user_api.navigation.UserLauncher
import javax.inject.Inject

internal class MainActivityViewModel @Inject constructor(
    private val userLauncher: UserLauncher,
    private val mainNavigationLauncher: MainNavigationLauncher,
    private val checkUserUseCase: CheckUserUseCase
) : ViewModel() {


    fun appStart() {
//        userLauncher.launchUserCreator()
//        mainNavigationLauncher.launchMainNavigation()
//        userLauncher.launchUserChoosing()
    }
}
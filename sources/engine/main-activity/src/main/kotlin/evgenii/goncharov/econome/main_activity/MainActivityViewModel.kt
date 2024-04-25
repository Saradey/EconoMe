package evgenii.goncharov.econome.main_activity

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.user_api.navigation.UserLauncher
import javax.inject.Inject

internal class MainActivityViewModel @Inject constructor(
    private val userLauncher: UserLauncher
) : ViewModel() {


    fun appStart() {
        userLauncher.launchUserCreator()
    }
}
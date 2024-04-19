package evgenii.goncharov.econome.main_activity

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.user_api.UserLauncher
import javax.inject.Inject

internal class MainActivityViewModel @Inject constructor(
    private val userLauncherImpl: UserLauncher
) : ViewModel() {


    fun appStart() {

    }
}
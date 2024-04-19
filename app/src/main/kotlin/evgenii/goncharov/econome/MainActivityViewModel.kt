package evgenii.goncharov.econome

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.user_api.UserLauncher
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val userLauncherImpl: UserLauncher
) : ViewModel() {


    fun appStart() {

    }
}
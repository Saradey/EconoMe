package evgenii.goncharov.econome.main_activity.navigation

import androidx.activity.OnBackPressedCallback
import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.navigation.utils.GLOBAL_ROUTER
import javax.inject.Inject
import javax.inject.Named

internal class MainOnBackPressed @Inject constructor(
    @Named(GLOBAL_ROUTER) private val globalRouter: Router
) : OnBackPressedCallback(true) {

    override fun handleOnBackPressed() {
        globalRouter.exit()
    }
}
package evgenii.goncharov.econome.main_navigation_impl.navigation

import androidx.activity.OnBackPressedCallback
import com.github.terrakok.cicerone.Router
import evgenii.goncharov.econome.navigation.utils.DEEP_ROUTER
import javax.inject.Inject
import javax.inject.Named

internal class BottomMenuOnBackPressed @Inject constructor(
    @Named(DEEP_ROUTER) private val deepRouter: Router
) : OnBackPressedCallback(true) {

    override fun handleOnBackPressed() {
        deepRouter.exit()
    }
}
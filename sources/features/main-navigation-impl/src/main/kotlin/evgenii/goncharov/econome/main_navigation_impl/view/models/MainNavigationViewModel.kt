package evgenii.goncharov.econome.main_navigation_impl.view.models

import androidx.lifecycle.ViewModel
import evgenii.goncharov.econome.main_api.navigation.MainLauncher
import javax.inject.Inject

internal class MainNavigationViewModel @Inject constructor(
    private val mainLauncher: MainLauncher
) : ViewModel() {

}
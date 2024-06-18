package evgenii.goncharov.econome.main_navigation_impl.fragments

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.main_navigation.di.MainNavigationApi
import evgenii.goncharov.econome.main_navigation_impl.di.contracts.MainNavigationInternal
import evgenii.goncharov.econome.main_navigation_impl.navigation.BottomMenuNavigator
import evgenii.goncharov.econome.main_navigation_impl.navigation.SelectedTabListener
import evgenii.goncharov.econome.main_navigation_impl.ui.MainNavigationScreen
import evgenii.goncharov.econome.main_navigation_impl.utils.toNavigationTabs
import evgenii.goncharov.econome.main_navigation_impl.view.models.MainNavigationViewModel

/**
 * 1. Screen
 */
internal class MainNavigationFragment : CoreFragment(),
    SelectedTabListener {

    private val dependency: MainNavigationInternal by lazy {
        getFeatureApi(MainNavigationApi::class.java) as MainNavigationInternal
    }
    private val viewModel: MainNavigationViewModel by viewModels {
        dependency.provideViewModelFactory()
    }
    override val layoutId: Int = View.generateViewId()
    private val bottomMenuNavigator by lazy {
        BottomMenuNavigator(
            fragmentContainer = this,
            globalRouter = dependency.provideGlobalRouter(),
            selectedTabListener = this,
            containerId = layoutId
        )
    }
    private val deepNavigatorHolder = dependency.provideDeepNavigatorHolder()
    private val onBackPressed = dependency.provideMainNavigation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?: viewModel.initMain()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressed)
    }

    @Composable
    override fun InitContent() = MainNavigationScreen(
        state = viewModel.uiState,
        tabBottomMenuListener = viewModel::selectedTab,
        selectedSettingsListener = viewModel::goToSettings,
        layoutId = layoutId
    )

    override fun onPause() {
        deepNavigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        deepNavigatorHolder.setNavigator(bottomMenuNavigator)
    }

    override fun selectTab(tabName: String) {
        viewModel.selectedTabOnlyUi(tabName.toNavigationTabs())
    }

    override fun releaseDependencies() {
        releaseFeatureApi(MainNavigationApi::class.java)
    }

    companion object {

        fun newInstance() = MainNavigationFragment()
    }
}
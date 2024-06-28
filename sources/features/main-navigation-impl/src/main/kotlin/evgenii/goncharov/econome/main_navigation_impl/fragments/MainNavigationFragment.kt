package evgenii.goncharov.econome.main_navigation_impl.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.fragment.app.FragmentContainerView
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
    private var fragmentContainerView: FragmentContainerView? = null
    private val bottomMenuNavigator by lazy {
        BottomMenuNavigator(
            fragmentContainer = this,
            globalRouter = dependency.provideGlobalRouter(),
            selectedTabListener = this,
        )
    }
    private val deepNavigatorHolder = dependency.provideDeepNavigatorHolder()
    private val onBackPressed = dependency.provideMainNavigation()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentContainerView = FragmentContainerView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            id = View.generateViewId()
            bottomMenuNavigator.setNewContainerId(id)
        }
    }

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
        container = fragmentContainerView ?: throw IllegalArgumentException(
            MESSAGE_ERROR_CONTAINER_MUST_NOT_NULL
        )
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

        private const val MESSAGE_ERROR_CONTAINER_MUST_NOT_NULL = "Container must not null"

        fun newInstance() = MainNavigationFragment()
    }
}
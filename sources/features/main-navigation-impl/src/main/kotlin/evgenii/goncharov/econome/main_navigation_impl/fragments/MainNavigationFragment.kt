package evgenii.goncharov.econome.main_navigation_impl.fragments

import android.os.Bundle
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.main_navigation.di.MainNavigationApi
import evgenii.goncharov.econome.main_navigation_impl.R
import evgenii.goncharov.econome.main_navigation_impl.di.contracts.MainNavigationInternal
import evgenii.goncharov.econome.main_navigation_impl.navigation.BottomMenuNavigator
import evgenii.goncharov.econome.main_navigation_impl.ui.MainNavigationScreen
import evgenii.goncharov.econome.main_navigation_impl.view.models.MainNavigationViewModel

/**
 * 1. Screen
 */
internal class MainNavigationFragment : CoreFragment(R.layout.fragment_main_navigation) {

    private val dependency: MainNavigationInternal by lazy {
        getFeatureApi(MainNavigationApi::class.java) as MainNavigationInternal
    }
    private val viewModel: MainNavigationViewModel by viewModels {
        dependency.provideViewModelFactory()
    }
    private val bottomMenuNavigator by lazy {
        BottomMenuNavigator(this)
    }
    private val deepNavigatorHolder = dependency.provideDeepNavigatorHolder()
    private val onBackPressedCallback = dependency.provideMainNavigation()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val container = view.findViewById<ComposeView>(R.id.cv_container)
        container.setContent {
            InitContent()
        }
        savedInstanceState ?: viewModel.initMain()
    }

    @Composable
    override fun InitContent() {
        MainNavigationScreen(
            viewModel.uiState,
            viewModel::selectedTab
        )
    }

    override fun onPause() {
        deepNavigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        deepNavigatorHolder.setNavigator(bottomMenuNavigator)
    }

    override fun releaseDependencies() {
        releaseFeatureApi(MainNavigationApi::class.java)
    }

    companion object {

        fun newInstance() = MainNavigationFragment()
    }
}
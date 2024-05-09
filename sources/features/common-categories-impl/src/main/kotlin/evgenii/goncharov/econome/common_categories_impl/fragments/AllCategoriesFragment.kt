package evgenii.goncharov.econome.common_categories_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.common_categories_api.di.AllCategoriesApi
import evgenii.goncharov.econome.common_categories_impl.di.contracts.AllCategoriesInternal
import evgenii.goncharov.econome.common_categories_impl.ui.AllCategoriesScreen
import evgenii.goncharov.econome.common_categories_impl.view.models.AllCategoriesViewModel
import evgenii.goncharov.econome.di_core.CoreFragment

/**
 * 11. Screen
 */
internal class AllCategoriesFragment : CoreFragment() {

    private val dependency: AllCategoriesInternal by lazy {
        getFeatureApi(AllCategoriesApi::class.java) as AllCategoriesInternal
    }
    private val viewModel: AllCategoriesViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = AllCategoriesScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(AllCategoriesApi::class.java)
    }

    companion object {

        fun newInstance() = AllCategoriesFragment()
    }
}
package evgenii.goncharov.econome.common_categories_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.common_categories_api.di.AddCategoriesApi
import evgenii.goncharov.econome.common_categories_impl.di.contracts.AddCategoriesInternal
import evgenii.goncharov.econome.common_categories_impl.ui.AddCategoriesScreen
import evgenii.goncharov.econome.common_categories_impl.view.models.AddCategoriesViewModel
import evgenii.goncharov.econome.di_core.CoreDialogFragment
import evgenii.goncharov.econome.di_core.extensions.getFeatureApi
import evgenii.goncharov.econome.di_core.extensions.releaseFeatureApi

/**
 * 12. Screen
 */
internal class AddCategoriesDialogFragment : CoreDialogFragment() {

    private val dependency: AddCategoriesInternal by lazy {
        getFeatureApi(AddCategoriesApi::class.java) as AddCategoriesInternal
    }
    private val viewModel: AddCategoriesViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = AddCategoriesScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(AddCategoriesApi::class.java)
    }

    companion object {

        fun newInstance() = AddCategoriesDialogFragment()
    }
}
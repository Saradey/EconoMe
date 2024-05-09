package evgenii.goncharov.econome.product_categories_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.product_categories_api.di.AddSubProductApi
import evgenii.goncharov.econome.product_categories_impl.di.contracts.AddSubProductInternal
import evgenii.goncharov.econome.product_categories_impl.ui.AddSubProductScreen
import evgenii.goncharov.econome.product_categories_impl.view.models.AddSubProductViewModel

/**
 * 22. Screen
 */
internal class AddSubProductFragment : CoreFragment() {

    private val dependency: AddSubProductInternal by lazy {
        getFeatureApi(AddSubProductApi::class.java) as AddSubProductInternal
    }
    private val viewModel: AddSubProductViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = AddSubProductScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(AddSubProductApi::class.java)
    }

    companion object {

        fun newInstance() = AddSubProductFragment()
    }
}
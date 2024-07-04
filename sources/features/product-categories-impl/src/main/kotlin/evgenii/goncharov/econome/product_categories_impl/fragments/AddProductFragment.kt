package evgenii.goncharov.econome.product_categories_impl.fragments

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreFragment
import evgenii.goncharov.econome.di_core.extensions.getFeatureApi
import evgenii.goncharov.econome.di_core.extensions.releaseFeatureApi
import evgenii.goncharov.econome.product_categories_api.di.AddProductApi
import evgenii.goncharov.econome.product_categories_impl.di.contracts.AddProductInternal
import evgenii.goncharov.econome.product_categories_impl.ui.AddProductScreen
import evgenii.goncharov.econome.product_categories_impl.view.models.AddProductViewModel

/**
 * 21. Screen
 */
internal class AddProductFragment : CoreFragment() {

    private val dependency: AddProductInternal by lazy {
        getFeatureApi(AddProductApi::class.java) as AddProductInternal
    }
    private val viewModel: AddProductViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = AddProductScreen()

    override fun releaseDependencies() {
        releaseFeatureApi(AddProductApi::class.java)
    }

    companion object {

        fun newInstance() = AddProductFragment()
    }
}
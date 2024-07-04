package evgenii.goncharov.econome.spending_impl.fragments

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import evgenii.goncharov.econome.di_core.CoreBottomSheetFragment
import evgenii.goncharov.econome.di_core.extensions.getFeatureApiWithParameters
import evgenii.goncharov.econome.di_core.extensions.releaseFeatureApi
import evgenii.goncharov.econome.spending_api.di.SpendingInfoApi
import evgenii.goncharov.econome.spending_impl.di.contracts.SpendingInfoInternal
import evgenii.goncharov.econome.spending_impl.di.holders.SpendingInfoHolder.Companion.SPENDING_ID_DI_KEY
import evgenii.goncharov.econome.spending_impl.ui.SpendingInfoScreen
import evgenii.goncharov.econome.spending_impl.view.models.SpendingInfoViewModel

/**
 * 5. Screen
 */
internal class SpendingInfoBottomSheetFragment : CoreBottomSheetFragment() {

    private val dependency: SpendingInfoInternal by lazy {
        getFeatureApiWithParameters(
            SpendingInfoApi::class.java,
            mapOf(SPENDING_ID_DI_KEY to arguments?.getLong(SPENDING_ID_KEY))
        ) as SpendingInfoInternal
    }
    private val viewModel: SpendingInfoViewModel by viewModels {
        dependency.provideViewModelFactory()
    }

    @Composable
    override fun InitContent() = SpendingInfoScreen(viewModel)

    override fun releaseDependencies() {
        releaseFeatureApi(SpendingInfoApi::class.java)
    }

    companion object {

        private const val SPENDING_ID_KEY = "SPENDING_ID_KEY"

        fun newInstance(spendingId: Long) = SpendingInfoBottomSheetFragment().apply {
            val args = Bundle()
            args.putLong(SPENDING_ID_KEY, spendingId)
            arguments = args
        }
    }
}
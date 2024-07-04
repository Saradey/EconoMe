package evgenii.goncharov.econome.spending_impl.di.assisted

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import evgenii.goncharov.econome.spending_impl.view.models.SpendingInfoViewModel
import javax.inject.Inject

internal class SpendingInfoViewModelProviderFactory @Inject constructor(
    private val factory: SpendingInfoViewModel.Factory,
    private val spendingId: Long,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return factory.create(spendingId) as T
    }
}
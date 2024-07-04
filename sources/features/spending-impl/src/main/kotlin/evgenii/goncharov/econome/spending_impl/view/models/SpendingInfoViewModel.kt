package evgenii.goncharov.econome.spending_impl.view.models

import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import evgenii.goncharov.econome.spending_impl.repositories.SpendingInfoRepository

internal class SpendingInfoViewModel @AssistedInject constructor(
    @Assisted private val spendingId: Long,
    private val spendingInfoRepository: SpendingInfoRepository
) : ViewModel() {

    @AssistedFactory
    interface Factory {

        fun create(spendingId: Long) : SpendingInfoViewModel
    }
}
package evgenii.goncharov.econome.spending_impl.view.models

import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import evgenii.goncharov.econome.common.ui.SystemEvent
import evgenii.goncharov.econome.spending_impl.models.SpendingInfoUiState
import evgenii.goncharov.econome.spending_impl.repositories.SpendingInfoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class SpendingInfoViewModel @AssistedInject constructor(
    @Assisted private val spendingId: Long,
    private val spendingInfoRepository: SpendingInfoRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<SpendingInfoUiState> = MutableStateFlow(
        SpendingInfoUiState()
    )
    val uiState: StateFlow<SpendingInfoUiState> = _uiState
    private val _systemEvent: MutableStateFlow<SystemEvent> = MutableStateFlow(
        SystemEvent.InitialState
    )
    val systemEvent: StateFlow<SystemEvent> = _systemEvent


    @AssistedFactory
    interface Factory {

        fun create(spendingId: Long): SpendingInfoViewModel
    }
}
package evgenii.goncharov.econome.spending_impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import evgenii.goncharov.econome.spending_impl.models.SpendingInfoModel
import evgenii.goncharov.econome.spending_impl.models.SpendingInfoUiState
import evgenii.goncharov.econome.spending_impl.view.models.SpendingInfoViewModel

@Composable
internal fun SpendingInfoScreen(
    viewModel: SpendingInfoViewModel
) {
    val uiState: SpendingInfoUiState by viewModel.uiState.collectAsStateWithLifecycle()
    SpendingInfoContent(
        modifier = Modifier.height(500.dp),
        spendingInfoModel = uiState.spendingInfoModel
    )
}

@Composable
private fun SpendingInfoContent(
    modifier: Modifier = Modifier,
    spendingInfoModel: SpendingInfoModel
) {
    Column(
        modifier = modifier
    ) {

    }
}
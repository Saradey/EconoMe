package evgenii.goncharov.econome.spending_impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        spendingInfoModel = uiState.spendingInfoModel,
        currentCurrencySymbol = uiState.currentCurrencySymbol
    )
}

@Composable
private fun SpendingInfoContent(
    modifier: Modifier = Modifier,
    spendingInfoModel: SpendingInfoModel,
    currentCurrencySymbol: String
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        TopContent(
            comment = spendingInfoModel.comment,
            amount = spendingInfoModel.amount,
            currentCurrencySymbol = currentCurrencySymbol,
            spendingTime = spendingInfoModel.spendingTime
        )
        CategoriesContent()
    }
}

@Composable
private fun TopContent(
    modifier: Modifier = Modifier,
    comment: String,
    amount: String,
    currentCurrencySymbol: String,
    spendingTime: String
) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "5. SpendingInfoBottomSheetFragment Диалоговое информации по расходу",
        color = Color.Black,
        fontSize = 20.sp,
        textAlign = TextAlign.Center
    )
    Text(
        modifier = Modifier
            .padding(16.dp),
        text = "Комментарий расхода: $comment",
        color = Color.Black,
        fontSize = 20.sp,
        textAlign = TextAlign.Center
    )
    Text(
        modifier = Modifier
            .padding(16.dp),
        text = "Сумма расхода: $amount $currentCurrencySymbol",
        color = Color.Black,
        fontSize = 20.sp,
        textAlign = TextAlign.Center
    )
    Text(
        modifier = Modifier
            .padding(16.dp),
        text = "Дата расхода: $spendingTime",
        color = Color.Black,
        fontSize = 20.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun CategoriesContent() {

}
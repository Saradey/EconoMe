package evgenii.goncharov.econome.spending_impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
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
        CategoriesContent(
            categories = spendingInfoModel.categories
        )
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
    Column(
        modifier = modifier.fillMaxWidth()
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
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun CategoriesContent(
    modifier: Modifier = Modifier,
    categories: List<String>
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp),
            text = "Список категорий:",
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        FlowRow(
            modifier = Modifier.padding(8.dp),
        ) {
            categories.forEach { title ->
                FilterChip(
                    selected = true,
                    onClick = {},
                    label = { Text(title) },
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}
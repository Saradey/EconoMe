package evgenii.goncharov.econome.main_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import evgenii.goncharov.econome.main_impl.view.models.MainViewModel

@Composable
internal fun MainScreen(
    viewModel: MainViewModel
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "2. MainFragment главный экран",
            color = Color.White,
            fontSize = 20.sp
        )
        Button(
            onClick = viewModel::goToDialogAddSpending,
        ) {
            Text("Go to 3. Диалоговое окно добавления расхода")
        }
        Button(
            onClick = viewModel::goToSpendingInfo,
        ) {
            Text("Go to 5. Экран информации по расходу")
        }
        Button(
            onClick = viewModel::goToAddSpendingLimit,
        ) {
            Text("Go to 10. Диалоговое окно по установки дневного лимита на расходы")
        }
        Button(
            onClick = viewModel::goToListShops,
        ) {
            Text("Go to 18. Список магазинов для анализа затрат")
        }
        Button(
            onClick = viewModel::goToAddCostGoods,
        ) {
            Text("Go to 19. Экран добавления стоимости товара")
        }
    }
}
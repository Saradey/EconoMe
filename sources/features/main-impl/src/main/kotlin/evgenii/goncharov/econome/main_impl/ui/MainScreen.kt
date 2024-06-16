package evgenii.goncharov.econome.main_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import evgenii.goncharov.econome.main_impl.models.MainUiState

@Composable
internal fun MainScreen(
    state: State<MainUiState>,
    goToDialogAddSpendingListener: () -> Unit,
    goToSpendingInfoListener: () -> Unit,
    goToAddSpendingLimitListener: () -> Unit,
    goToListShopsListener: () -> Unit,
    goToAddCostGoodsListener: () -> Unit,
) {
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
            onClick = goToDialogAddSpendingListener,
        ) {
            Text("Go to 3. Диалоговое окно добавления расхода")
        }
        Button(
            onClick = goToSpendingInfoListener,
        ) {
            Text("Go to 5. Экран информации по расходу")
        }
        Button(
            onClick = goToAddSpendingLimitListener,
        ) {
            Text("Go to 10. Диалоговое окно по установки дневного лимита на расходы")
        }
        Button(
            onClick = goToListShopsListener,
        ) {
            Text("Go to 18. Список магазинов для анализа затрат")
        }
        Button(
            onClick = goToAddCostGoodsListener,
        ) {
            Text("Go to 19. Экран добавления стоимости товара")
        }
    }
}
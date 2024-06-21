package evgenii.goncharov.econome.main_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import evgenii.goncharov.econome.main_impl.models.MainUiState
import evgenii.goncharov.econome.main_impl.view.models.MainViewModel

@Composable
internal fun MainScreen(
    viewModel: MainViewModel
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    when (state) {
        is MainUiState.Content -> MainScreenContent(
            modifier = Modifier.fillMaxSize(),
            state = state as MainUiState.Content,
            goToDialogAddSpending = viewModel::goToDialogAddSpending,
            goToSpendingInfo = viewModel::goToSpendingInfo,
            goToAddSpendingLimit = viewModel::goToAddSpendingLimit,
            goToListShops = viewModel::goToListShops,
            goToAddCostGoods = viewModel::goToAddCostGoods
        )

        MainUiState.InitialState -> Unit
    }
}

@Composable
private fun MainScreenContent(
    modifier: Modifier = Modifier,
    state: MainUiState.Content,
    goToDialogAddSpending: () -> Unit,
    goToSpendingInfo: () -> Unit,
    goToAddSpendingLimit: () -> Unit,
    goToListShops: () -> Unit,
    goToAddCostGoods: () -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        HeaderInfo(
            userName = state.currentUser.userName,
            walletName = state.currentUser.walletName
        )
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
                onClick = goToDialogAddSpending,
            ) {
                Text("Go to 3. Диалоговое окно добавления расхода")
            }
            Button(
                onClick = goToSpendingInfo,
            ) {
                Text("Go to 5. Экран информации по расходу")
            }
            Button(
                onClick = goToAddSpendingLimit,
            ) {
                Text("Go to 10. Диалоговое окно по установки дневного лимита на расходы")
            }
            Button(
                onClick = goToListShops,
            ) {
                Text("Go to 18. Список магазинов для анализа затрат")
            }
            Button(
                onClick = goToAddCostGoods,
            ) {
                Text("Go to 19. Экран добавления стоимости товара")
            }
        }
    }
}

@Composable
private fun HeaderInfo(
    modifier: Modifier = Modifier,
    userName: String,
    walletName: String
) {
    Column(
        modifier = modifier.fillMaxWidth().padding(16.dp)
    ) {
        Text(
            text = userName,
            color = Color.White,
            fontSize = 18.sp
        )
        Text(
            text = walletName,
            color = Color.White,
            fontSize = 18.sp
        )
    }
}
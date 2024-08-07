package evgenii.goncharov.econome.main_impl.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import evgenii.goncharov.econome.main_impl.models.SpendingItemModel
import evgenii.goncharov.econome.main_impl.view.models.MainViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.text.style.TextOverflow

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
    goToSpendingInfo: (Long) -> Unit,
    goToAddSpendingLimit: () -> Unit,
    goToListShops: () -> Unit,
    goToAddCostGoods: () -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        HeaderInfo(
            userName = state.currentUser.userName,
            walletName = state.currentUser.walletName,
            sumSpending = state.spendingToday.spendingToday,
            currency = state.currencyCharacter
        )
        Button(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = goToDialogAddSpending,
        ) {
            Text("Добавить расход")
        }
        ListSpendingToday(
            spendingListToday = state.spendingListToday,
            currentCurrencySymbol = state.currencyCharacter,
            spendingInfoClickListener = goToSpendingInfo
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
    walletName: String,
    sumSpending: String,
    currency: String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Текущий пользователь: $userName",
            color = Color.White,
            fontSize = 18.sp
        )
        Text(
            text = "Текущий кошелек: $walletName",
            color = Color.White,
            fontSize = 18.sp
        )
        Text(
            text = "Сумма расходов за сегодня: $sumSpending $currency",
            color = Color.White,
            fontSize = 18.sp
        )
    }
}

@Composable
private fun ListSpendingToday(
    modifier: Modifier = Modifier,
    spendingListToday: List<SpendingItemModel>,
    currentCurrencySymbol: String,
    spendingInfoClickListener: (Long) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Список расходов за сегодня:",
            color = Color.White,
            fontSize = 18.sp
        )
        if (spendingListToday.isNotEmpty()) {
            ListSpendings(
                spendingListToday = spendingListToday,
                currentCurrencySymbol = currentCurrencySymbol,
                spendingInfoClickListener = spendingInfoClickListener
            )
        } else {
            EmptyListSpending()
        }
    }
}

@Composable
private fun EmptyListSpending(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Расходы за сегодня отсутствуют",
            color = Color.White,
            fontSize = 18.sp
        )
    }
}

@Composable
private fun ListSpendings(
    modifier: Modifier = Modifier,
    spendingListToday: List<SpendingItemModel>,
    currentCurrencySymbol: String,
    spendingInfoClickListener: (Long) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        items(spendingListToday) { item ->
            HorizontalDivider(color = Color.White, thickness = 1.dp)
            ItemSpendingToday(
                title = "${item.number}. ${item.amount} $currentCurrencySymbol",
                categoriesTitle = item.spendingCategoryTitle,
                spendingTime = item.spendingTime,
                comment = item.comment
            ) {
                spendingInfoClickListener(item.idSpending)
            }
            HorizontalDivider(color = Color.White, thickness = 1.dp)
        }
    }
}

@Composable
private fun ItemSpendingToday(
    modifier: Modifier = Modifier,
    title: String,
    categoriesTitle: List<String>,
    spendingTime: String,
    comment: String,
    clickListener: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { clickListener() }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(end = 8.dp),
                text = title,
                maxLines = 1,
                color = Color.White,
                fontSize = 16.sp
            )
            Text(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .weight(1f),
                text = "Категории: ${categoriesTitle.joinToString("/")}",
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp
            )
            Text(
                text = spendingTime,
                color = Color.White,
                fontSize = 16.sp
            )
        }
        Text(
            text = "Комментарий: $comment",
            maxLines = 1,
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            fontSize = 16.sp
        )
    }
}
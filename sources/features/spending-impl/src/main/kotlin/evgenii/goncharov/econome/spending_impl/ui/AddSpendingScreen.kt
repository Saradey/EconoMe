package evgenii.goncharov.econome.spending_impl.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import evgenii.goncharov.econome.spending_impl.models.AddSpendingUiState
import evgenii.goncharov.econome.spending_impl.models.SpendingCategory
import evgenii.goncharov.econome.spending_impl.view.models.AddSpendingViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.res.painterResource
import evgenii.goncharov.econome.ui_kit.UiKitDrawable

@Composable
internal fun AddSpendingScreen(viewModel: AddSpendingViewModel) {
    val uiState: AddSpendingUiState by viewModel.uiState.collectAsStateWithLifecycle()
    AddSpendingContent(
        modifier = Modifier.height(500.dp),
        uiState = uiState,
        inputSpendingListener = viewModel::inputSpending,
        inputCommentListener = viewModel::inputComment,
        chipsClickListener = viewModel::chooseSpendingCategory,
        createSpendingClickListener = viewModel::createSpending,
        closeClickListener = viewModel::clickClose
    )
}

@Composable
private fun AddSpendingContent(
    modifier: Modifier = Modifier,
    inputSpendingListener: (String) -> Unit,
    inputCommentListener: (String) -> Unit,
    chipsClickListener: (Long) -> Unit,
    createSpendingClickListener: () -> Unit,
    closeClickListener: () -> Unit,
    uiState: AddSpendingUiState
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "3. AddSpendingDialogFragment Диалоговое окно добавления расхода",
                color = Color.Black,
                fontSize = 20.sp
            )
            Icon(
                modifier = Modifier.clickable { closeClickListener() },
                painter = painterResource(UiKitDrawable.ic_close_square),
                contentDescription = null
            )
        }
        InputTextFieldWithTitle(
            inputListener = inputSpendingListener,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            textTitle = "Введите сумму расхода:",
            value = uiState.inputSpending
        )
        InputTextFieldWithTitle(
            inputListener = inputCommentListener,
            textTitle = "Введите комментарий:",
            value = uiState.inputComment
        )
        ChipsMenu(
            categories = uiState.spendingCategories,
            titleChipsMenu = "Выберите тип расхода:",
            chipsClickListener = chipsClickListener
        )
        MainButton(
            isEnabled = uiState.mainButtonEnabled,
            createSpendingClickListener = createSpendingClickListener
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputTextFieldWithTitle(
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    inputListener: (String) -> Unit,
    textTitle: String,
    value: String,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = textTitle,
            color = Color.Black,
            fontSize = 24.sp
        )
        OutlinedTextField(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            value = value,
            onValueChange = inputListener,
            keyboardOptions = keyboardOptions,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Green,
                unfocusedBorderColor = Color.Green,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
            )
        )
    }
}

@Composable
private fun ChipsMenu(
    modifier: Modifier = Modifier,
    categories: List<SpendingCategory>,
    titleChipsMenu: String,
    chipsClickListener: (Long) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = titleChipsMenu,
            color = Color.Black,
            fontSize = 24.sp
        )
        LazyRow(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(categories) { item ->
                ChipItem(
                    title = item.title,
                    isSelected = item.isSelected
                ) {
                    chipsClickListener(item.id)
                }
            }
        }
    }
}

@Composable
private fun ChipItem(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    FilterChip(
        selected = isSelected,
        onClick = onClick,
        label = { Text(text = title) },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Color.Blue,
            selectedLabelColor = Color.White,
            containerColor = Color.LightGray,
            labelColor = Color.Black
        ),
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
private fun MainButton(
    modifier: Modifier = Modifier,
    isEnabled: Boolean,
    createSpendingClickListener: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 32.dp)
    ) {
        Button(
            onClick = { createSpendingClickListener() },
            enabled = isEnabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isEnabled) Color.Blue else Color.Gray,
                disabledContainerColor = Color.Gray,
                contentColor = if (isEnabled) Color.White else Color.Black,
                disabledContentColor = Color.DarkGray
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = modifier
                .fillMaxWidth(fraction = 0.8f)
                .align(Alignment.CenterHorizontally)
                .background(if (isEnabled) Color.Blue else Color.Gray)
                .padding(16.dp)
        ) {
            Text(
                text = "Внести расход",
                fontSize = 24.sp
            )
        }
    }
}
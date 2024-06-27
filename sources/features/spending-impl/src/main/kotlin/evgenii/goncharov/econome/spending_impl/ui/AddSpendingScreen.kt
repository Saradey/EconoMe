package evgenii.goncharov.econome.spending_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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

@Composable
internal fun AddSpendingScreen(viewMode: AddSpendingViewModel) {
    val uiState: AddSpendingUiState by viewMode.uiState.collectAsStateWithLifecycle()

    AddSpendingContent(
        modifier = Modifier.height(500.dp),
        uiState = uiState,
        inputSpendingListener = viewMode::inputSpending,
        inputCommentListener = viewMode::inputComment,
        chipsClickListener = viewMode::chooseSpendingCategory
    )
}

@Composable
private fun AddSpendingContent(
    modifier: Modifier = Modifier,
    inputSpendingListener: (String) -> Unit,
    inputCommentListener: (String) -> Unit,
    chipsClickListener: (Long) -> Unit,
    uiState: AddSpendingUiState
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "3. AddSpendingDialogFragment Диалоговое окно добавления расхода",
            color = Color.Black,
            fontSize = 20.sp
        )
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
            chipsClickListener = chipsClickListener
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
internal fun ChipsMenu(
    modifier: Modifier = Modifier,
    categories: List<SpendingCategory>,
    chipsClickListener: (Long) -> Unit
) {
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

@Composable
internal fun ChipItem(
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
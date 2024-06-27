package evgenii.goncharov.econome.spending_impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
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
import evgenii.goncharov.econome.spending_impl.view.models.AddSpendingViewModel

@Composable
internal fun AddSpendingScreen(viewMode: AddSpendingViewModel) {
    val uiState: AddSpendingUiState by viewMode.uiState.collectAsStateWithLifecycle()

    AddSpendingContent(
        modifier = Modifier.height(500.dp),
        uiState = uiState,
        inputSpendingListener = viewMode::inputSpending,
        inputCommentListener = viewMode::inputComment
    )
}

@Composable
private fun AddSpendingContent(
    modifier: Modifier = Modifier,
    inputSpendingListener: (String) -> Unit,
    inputCommentListener: (String) -> Unit,
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
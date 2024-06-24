package evgenii.goncharov.econome.spending_impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import evgenii.goncharov.econome.spending_impl.view.models.AddSpendingViewModel

@Composable
internal fun AddSpendingScreen(viewMode: AddSpendingViewModel) {
    AddSpendingContent(
        modifier = Modifier.height(400.dp),
        inputSpendingListener = viewMode::inputSpending
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddSpendingContent(
    modifier: Modifier = Modifier,
    inputSpendingListener: (String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "3. AddSpendingDialogFragment Диалоговое окно добавления расхода",
            color = Color.Black,
            fontSize = 20.sp
        )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Введите сумму расхода:",
            color = Color.Black,
            fontSize = 24.sp
        )
        OutlinedTextField(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            value = "",
            onValueChange = inputSpendingListener,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Green,
                unfocusedBorderColor = Color.Green,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
            )
        )
    }
}
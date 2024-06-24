package evgenii.goncharov.econome.spending_impl.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import evgenii.goncharov.econome.spending_impl.view.models.AddSpendingViewModel

@Composable
internal fun AddSpendingScreen(viewMode: AddSpendingViewModel) {
    Text(
        text = "3. AddSpendingDialogFragment Диалоговое окно добавления расхода",
        color = Color.Black,
        fontSize = 20.sp
    )
}


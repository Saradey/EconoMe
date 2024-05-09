package evgenii.goncharov.econome.bank_accounts_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
internal fun AddPatternAccountScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "14. AddPatternAccountBottomSheetFragment Диалоговое окно по добавлению шаблона денежного счета",
            color = Color.Black,
            fontSize = 20.sp
        )
    }
}
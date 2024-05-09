package evgenii.goncharov.econome.bank_accounts_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
internal fun AddStateAccountScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "8. AddStateAccountBottomSheetFragment Диалоговое окно по добавлению информации о денежном состоянии",
            color = Color.Black,
            fontSize = 20.sp
        )
    }
}
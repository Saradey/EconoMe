package evgenii.goncharov.econome.main_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
internal fun SpendingLimitScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "10. SpendingLimitDialogFragment Диалоговое окно по установки дневного лимита на расходы",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}
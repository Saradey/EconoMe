package evgenii.goncharov.econome.all_spending_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
internal fun AllSpendingScreen(
    goToSpendingInfo: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "6. AllSpendingFragment экран всех расходов",
            color = Color.White,
            fontSize = 20.sp
        )
        Button(
            onClick = goToSpendingInfo,
        ) {
            Text("Go to 5. Экран информации по расходу")
        }
    }
}
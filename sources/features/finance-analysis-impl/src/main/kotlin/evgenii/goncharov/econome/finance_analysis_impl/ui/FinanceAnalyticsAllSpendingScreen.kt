package evgenii.goncharov.econome.finance_analysis_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
internal fun FinanceAnalyticsAllSpendingScreen(
    goToFinanceAnalytics: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "13. FinanceAnalyticsAllSpendingFragment экран всех расходов аналитика",
            color = Color.White,
            fontSize = 20.sp
        )
        Button(
            onClick = goToFinanceAnalytics,
        ) {
            Text("Go to 17. Экран аналитики финансов")
        }
    }
}
package evgenii.goncharov.econome.bank_accounts_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
internal fun BankAccountsScreen(
    goToAddStateAccount: () -> Unit,
    goToAddPatternAccount: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "7. BankAccountsFragment экран о состоянии счетов",
            color = Color.White,
            fontSize = 20.sp
        )
        Button(
            onClick = goToAddStateAccount,
        ) {
            Text("Go to 8. Диалоговое окно по добавлению информации о денежном состоянии")
        }
        Button(
            onClick = goToAddPatternAccount,
        ) {
            Text("Go to 14. Диалоговое окно по добавлению шаблона денежного счета")
        }
    }
}
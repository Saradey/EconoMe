package evgenii.goncharov.econome.settings_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
internal fun SettingsScreen(
    goToUserCreator: () -> Unit,
    goToUserChoosing: () -> Unit,
    goToWalletCreator: () -> Unit,
    goToAllWallet: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "9. SettingsFragment экран настроек",
            color = Color.White,
            fontSize = 20.sp
        )
        Button(
            onClick = goToUserCreator,
        ) {
            Text("Go to 0. Экран создания аккаунта")
        }
        Button(
            onClick = goToUserChoosing,
        ) {
            Text("Go to 15. Экран выбора пользователя")
        }
        Button(
            onClick = goToWalletCreator,
        ) {
            Text("Go to 4. Экран создания кошелька расходов")
        }
        Button(
            onClick = goToAllWallet,
        ) {
            Text("Go to 16. Экран всех кошельков")
        }
    }
}
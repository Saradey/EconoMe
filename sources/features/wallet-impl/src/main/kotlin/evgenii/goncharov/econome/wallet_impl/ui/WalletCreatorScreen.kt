package evgenii.goncharov.econome.wallet_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
internal fun WalletCreatorScreen(
    goToBottomMenuListener: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "4. WalletCreatorFragment Экран создания кошелька расходов",
            color = Color.White,
            fontSize = 20.sp
        )
        Button(
            onClick = goToBottomMenuListener,
        ) {
            Text("Go to 1. Экран с нижнем bottomNavigation меню")
        }
    }
}
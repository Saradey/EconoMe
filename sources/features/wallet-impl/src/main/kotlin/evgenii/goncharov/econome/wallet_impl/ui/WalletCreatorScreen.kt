package evgenii.goncharov.econome.wallet_impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import evgenii.goncharov.econome.wallet_impl.view.models.WalletCreatorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun WalletCreatorScreen(
    viewModel: WalletCreatorViewModel,
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
        OutlinedTextField(
            value = "",
            onValueChange = viewModel::inputWalletName,
            label = { Text("Введите название кошелька") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White
            )
        )
        Text(
            text = "Выбирите валюту кошелька:",
            color = Color.White,
            fontSize = 20.sp
        )
    }
}
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import evgenii.goncharov.econome.wallet_impl.R
import evgenii.goncharov.econome.wallet_impl.models.WalletCreatorUiState
import evgenii.goncharov.econome.wallet_impl.view.models.WalletCreatorViewModel

@Composable
internal fun WalletCreatorScreen(
    viewModel: WalletCreatorViewModel,
) {
    val state = viewModel.uiState.value as WalletCreatorUiState.Content
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "4. WalletCreatorFragment Экран создания кошелька расходов",
            color = Color.White,
            fontSize = 20.sp
        )
        InputWalletNameField(
            inputWalletName = state.inputWalletName,
            inputWalletNameListener = viewModel::inputWalletName
        )
        Text(
            text = stringResource(id = R.string.choose_currency_title),
            color = Color.White,
            fontSize = 20.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputWalletNameField(
    inputWalletName: String,
    inputWalletNameListener: (String) -> Unit
) {
    OutlinedTextField(
        value = inputWalletName,
        onValueChange = inputWalletNameListener,
        label = { Text(stringResource(id = R.string.input_name_wallet_title)) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White
        )
    )
}
package evgenii.goncharov.econome.wallet_impl.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import evgenii.goncharov.econome.common.consts.CurrencyCode
import evgenii.goncharov.econome.wallet_impl.R
import evgenii.goncharov.econome.wallet_impl.models.CurrencyModel
import evgenii.goncharov.econome.wallet_impl.view.models.WalletCreatorViewModel

@Composable
internal fun WalletCreatorScreen(
    viewModel: WalletCreatorViewModel,
) {
    val state = viewModel.uiState.value
    Column {
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
        CurrenciesList(
            items = state.currencies,
            chooseLanguage = viewModel::chooseCurrency
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputWalletNameField(
    modifier: Modifier = Modifier,
    inputWalletName: String,
    inputWalletNameListener: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
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

@Composable
private fun CurrenciesList(
    modifier: Modifier = Modifier,
    items: List<CurrencyModel>,
    chooseLanguage: (CurrencyCode) -> Unit
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        items.forEach { model ->
            ItemCurrency(
                title = model.title,
                switch = model.switch,
                icon = model.icon,
                chooseLanguage = {
                    chooseLanguage(model.code)
                }
            )
        }
    }
}

@Composable
private fun ItemCurrency(
    modifier: Modifier = Modifier,
    title: String,
    switch: Boolean,
    @DrawableRes icon: Int,
    chooseLanguage: () -> Unit
) {
    Row(
        modifier = modifier.padding(16.dp),
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            fontSize = 16.sp
        )
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null
        )
    }
}
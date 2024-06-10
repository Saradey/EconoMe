package evgenii.goncharov.econome.wallet_impl.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import evgenii.goncharov.econome.common.consts.CurrencyCode
import evgenii.goncharov.econome.ui_kit.UiKitDrawable
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
            modifier = Modifier.padding(top = 12.dp),
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
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
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
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            color = Color.White,
            fontSize = 20.sp
        )
        Box(
            modifier = Modifier.size(40.dp)
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null
            )
            if (switch) {
                Icon(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxSize(),
                    painter = painterResource(id = UiKitDrawable.ic_check_green_24),
                    tint = Color.Green,
                    contentDescription = null
                )
            }
        }
    }
}
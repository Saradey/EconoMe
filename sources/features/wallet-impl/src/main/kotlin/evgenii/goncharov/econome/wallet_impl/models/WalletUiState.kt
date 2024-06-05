package evgenii.goncharov.econome.wallet_impl.models

internal data class WalletUiState(
    val inputWalletName: String,
    val currencies: List<CurrencyModel>
)
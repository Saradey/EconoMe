package evgenii.goncharov.econome.wallet_impl.models

internal sealed class WalletCreatorUiState {

    data class Content(
        val inputWalletName: String,
        val currencies: List<CurrencyModel>
    ) : WalletCreatorUiState()
}
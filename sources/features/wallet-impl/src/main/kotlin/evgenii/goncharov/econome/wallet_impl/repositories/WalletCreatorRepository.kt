package evgenii.goncharov.econome.wallet_impl.repositories

import evgenii.goncharov.econome.common.consts.CurrencyCode
import evgenii.goncharov.econome.wallet_impl.models.CurrencyModel

internal interface WalletCreatorRepository {

    suspend fun formCurrencies(): List<CurrencyModel>

    fun updateCurrencyCodeSelected(currencyCodeSelected: CurrencyCode)

    fun updateWalletName(walletName: String)

    suspend fun makeWallet()
}
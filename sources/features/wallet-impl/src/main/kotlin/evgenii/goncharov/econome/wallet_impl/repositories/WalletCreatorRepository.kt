package evgenii.goncharov.econome.wallet_impl.repositories

import evgenii.goncharov.econome.wallet_impl.models.CurrencyModel

internal interface WalletCreatorRepository {

    suspend fun formCurrencies(): List<CurrencyModel>
}
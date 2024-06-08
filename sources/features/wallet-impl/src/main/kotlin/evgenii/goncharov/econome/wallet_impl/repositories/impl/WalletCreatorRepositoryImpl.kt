package evgenii.goncharov.econome.wallet_impl.repositories.impl

import evgenii.goncharov.econome.core_database_api.data.stores.WalletDataStore
import evgenii.goncharov.econome.currency.data.store.CurrencyDataStore
import evgenii.goncharov.econome.wallet_impl.models.CurrencyModel
import evgenii.goncharov.econome.wallet_impl.models.mappers.CurrencyDtoToCurrencyModelMapper
import evgenii.goncharov.econome.wallet_impl.repositories.WalletCreatorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class WalletCreatorRepositoryImpl @Inject constructor(
    private val walletDataStore: WalletDataStore,
    private val currencyDataStore: CurrencyDataStore,
    private val currencyDtoToCurrencyModelMapper: CurrencyDtoToCurrencyModelMapper
) : WalletCreatorRepository {

    override suspend fun formCurrencies(): List<CurrencyModel> = withContext(Dispatchers.IO) {
        currencyDataStore.getCurrencies().map { currencyDto ->
            currencyDtoToCurrencyModelMapper.map(currencyDto)
        }
    }
}
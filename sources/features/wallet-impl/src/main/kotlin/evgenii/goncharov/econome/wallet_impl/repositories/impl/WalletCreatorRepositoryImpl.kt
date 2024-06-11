package evgenii.goncharov.econome.wallet_impl.repositories.impl

import evgenii.goncharov.econome.common.consts.CurrencyCode
import evgenii.goncharov.econome.core_database_api.data.stores.WalletDataStore
import evgenii.goncharov.econome.core_database_api.dto.WalletDto
import evgenii.goncharov.econome.currency.data.store.CurrencyDataStore
import evgenii.goncharov.econome.wallet_impl.models.CurrencyModel
import evgenii.goncharov.econome.wallet_impl.models.mappers.CurrencyDtoToCurrencyModelMapper
import evgenii.goncharov.econome.wallet_impl.repositories.WalletCreatorRepository
import evgenii.goncharov.econome.wallet_impl.utils.IdGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class WalletCreatorRepositoryImpl @Inject constructor(
    private val walletDataStore: WalletDataStore,
    private val currencyDataStore: CurrencyDataStore,
    private val currencyDtoToCurrencyModelMapper: CurrencyDtoToCurrencyModelMapper
) : WalletCreatorRepository {

    private var currencyCodeSelected: CurrencyCode? = null
    private var walletName: String? = null

    override suspend fun formCurrencies(): List<CurrencyModel> = withContext(Dispatchers.IO) {
        currencyDataStore.getCurrencies().map { currencyDto ->
            currencyDtoToCurrencyModelMapper.map(currencyDto)
        }
    }

    override fun updateCurrencyCodeSelected(currencyCodeSelected: CurrencyCode) {
        this.currencyCodeSelected = currencyCodeSelected
    }

    override fun updateWalletName(walletName: String) {
        this.walletName = walletName
    }

    override suspend fun makeWallet() = withContext(Dispatchers.IO) {
        val lastSequenceNumber = walletDataStore.getLastWalletSequenceNumber()
        walletDataStore.saveNewWallet(
            WalletDto(
                id = IdGenerator.generateId(),
                walletName = walletName ?: throw IllegalArgumentException(WALLET_MUST_NOT_NULL),
                code = currencyCodeSelected?.code ?: throw IllegalArgumentException(
                    CURRENCY_CODE_MUST_NOT_NULL
                ),
                sequenceNumber = lastSequenceNumber + 1
            )
        )
    }

    private companion object {

        const val WALLET_MUST_NOT_NULL = "wallet must not null"
        const val CURRENCY_CODE_MUST_NOT_NULL = "currency code must not null"
    }
}
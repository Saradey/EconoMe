package evgenii.goncharov.econome.wallet_impl.repositories.impl

import evgenii.goncharov.econome.common.consts.CurrencyCode
import evgenii.goncharov.econome.core_database_api.data.stores.CurrentWalletDataStore
import evgenii.goncharov.econome.core_database_api.data.stores.WalletDataStore
import evgenii.goncharov.econome.core_database_api.dto.CurrentWalletDto
import evgenii.goncharov.econome.core_database_api.dto.WalletDto
import evgenii.goncharov.econome.currency.data.store.CurrencyDataStore
import evgenii.goncharov.econome.wallet_impl.models.CurrencyModel
import evgenii.goncharov.econome.wallet_impl.models.mappers.CurrencyDtoToCurrencyModelMapper
import evgenii.goncharov.econome.wallet_impl.repositories.WalletCreatorRepository
import evgenii.goncharov.econome.wallet_impl.utils.IdWalletGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class WalletCreatorRepositoryImpl @Inject constructor(
    private val walletDataStore: WalletDataStore,
    private val currencyDataStore: CurrencyDataStore,
    private val currencyDtoToCurrencyModelMapper: CurrencyDtoToCurrencyModelMapper,
    private val currentWalletDataStore: CurrentWalletDataStore
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

    override suspend fun makeWallet(currentUserId: String) : Long = withContext(Dispatchers.IO) {
        val walletId = IdWalletGenerator.generateId()
        saveNewWallet(currentUserId, walletId)
        currentWalletDataStore.saveCurrentWallet(CurrentWalletDto(currentWalletId = walletId))
        walletId
    }

    private suspend fun saveNewWallet(
        currentUserId: String,
        walletId: Long
    ) {
        val lastSequenceNumber = walletDataStore.getLastWalletSequenceNumber()
        walletDataStore.saveNewWallet(
            WalletDto(
                walletId = walletId,
                walletName = walletName ?: throw IllegalArgumentException(WALLET_MUST_NOT_NULL),
                currencyCode = currencyCodeSelected?.code ?: throw IllegalArgumentException(
                    CURRENCY_CODE_MUST_NOT_NULL
                ),
                sequenceNumber = lastSequenceNumber + 1,
                userId = currentUserId
            )
        )
    }

    private companion object {

        const val WALLET_MUST_NOT_NULL = "wallet must not null"
        const val CURRENCY_CODE_MUST_NOT_NULL = "currency code must not null"
    }
}
package evgenii.goncharov.econome.currency.data.store.impl

import evgenii.goncharov.econome.common.readRawCurrency
import evgenii.goncharov.econome.common_provider.managers.ResourceManager
import evgenii.goncharov.econome.currency.R
import evgenii.goncharov.econome.currency.data.store.CurrencyDataStore
import evgenii.goncharov.econome.currency.models.CurrencyDto
import evgenii.goncharov.econome.currency.models.CurrencyListDto
import kotlinx.serialization.json.Json
import javax.inject.Inject

internal class CurrencyDataStoreImpl @Inject constructor(
    private val resourceManager: ResourceManager,
    private val json: Json
) : CurrencyDataStore {

    private var cacheCurrency: CurrencyListDto? = null

    override fun getCurrencies(): List<CurrencyDto> {
        val currencies = cacheCurrency?.currencies ?: let {
            val rawCurrency = resourceManager.getRawFile(R.raw.currency_list)
            val rawJsonCurrency = readRawCurrency(rawCurrency)
            val currency = json.decodeFromString<CurrencyListDto>(rawJsonCurrency)
            cacheCurrency = currency
            currency.currencies
        }
        return currencies
    }
}
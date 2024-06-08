package evgenii.goncharov.econome.currency.data.store.impl

import evgenii.goncharov.econome.common_provider.managers.ResourceManager
import evgenii.goncharov.econome.currency.data.store.CurrencyDataStore
import evgenii.goncharov.econome.currency.models.CurrencyDto
import kotlinx.serialization.json.Json
import javax.inject.Inject

internal class CurrencyDataStoreImpl @Inject constructor(
    private val resourceManager: ResourceManager,
    private val json: Json
) : CurrencyDataStore {



    override fun getCurrencies(): List<CurrencyDto> {
        return emptyList()
    }
}
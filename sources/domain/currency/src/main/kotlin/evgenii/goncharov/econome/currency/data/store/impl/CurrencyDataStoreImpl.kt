package evgenii.goncharov.econome.currency.data.store.impl

import android.content.Context
import evgenii.goncharov.econome.currency.data.store.CurrencyDataStore
import kotlinx.serialization.json.Json
import javax.inject.Inject

internal class CurrencyDataStoreImpl @Inject constructor(
    private val appContext: Context,
    private val json: Json
) : CurrencyDataStore {

}
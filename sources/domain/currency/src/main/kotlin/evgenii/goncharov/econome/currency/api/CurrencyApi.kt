package evgenii.goncharov.econome.currency.api

import evgenii.goncharov.econome.currency.data.store.CurrencyDataStore

public interface CurrencyApi {

    public fun provideCurrencyDataStore(): CurrencyDataStore
}
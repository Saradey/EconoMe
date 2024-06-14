package evgenii.goncharov.econome.currency.data.store

import evgenii.goncharov.econome.currency.models.CurrencyDto

public interface CurrencyDataStore {

    public fun getCurrencies() : List<CurrencyDto>
}
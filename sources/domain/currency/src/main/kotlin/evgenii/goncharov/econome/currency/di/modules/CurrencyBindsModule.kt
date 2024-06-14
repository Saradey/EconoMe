package evgenii.goncharov.econome.currency.di.modules

import dagger.Binds
import dagger.Module
import evgenii.goncharov.econome.currency.data.store.CurrencyDataStore
import evgenii.goncharov.econome.currency.data.store.impl.CurrencyDataStoreImpl
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@Module
internal interface CurrencyBindsModule {

    @Binds
    @CoreScope
    fun bindCurrencyDataStore(store : CurrencyDataStoreImpl) : CurrencyDataStore
}
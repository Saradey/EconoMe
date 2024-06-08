package evgenii.goncharov.econome.currency.di

import dagger.Component
import evgenii.goncharov.econome.currency.api.CurrencyApi
import evgenii.goncharov.econome.currency.models.CurrencyBindsModule

@Component(
    dependencies = [],
    modules = [CurrencyBindsModule::class]
)
internal interface CurrencyComponent : CurrencyApi {

}
package evgenii.goncharov.econome.currency.di

import dagger.Component
import evgenii.goncharov.econome.common_provider.di.CommonProviderApi
import evgenii.goncharov.econome.currency.api.CurrencyApi
import evgenii.goncharov.econome.currency.di.models.CurrencyBindsModule
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@CoreScope
@Component(
    dependencies = [CommonProviderApi::class],
    modules = [CurrencyBindsModule::class]
)
internal interface CurrencyComponent : CurrencyApi {

    @Component.Factory
    interface Factory {

        fun create(
            commonProviderApi: CommonProviderApi
        ): CurrencyComponent
    }
}
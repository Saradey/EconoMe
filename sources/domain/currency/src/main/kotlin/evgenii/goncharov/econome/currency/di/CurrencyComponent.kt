package evgenii.goncharov.econome.currency.di

import dagger.Component
import evgenii.goncharov.econome.common_provider.di.api.CommonProviderApi
import evgenii.goncharov.econome.currency.api.CurrencyApi
import evgenii.goncharov.econome.currency.di.modules.CurrencyBindsModule
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
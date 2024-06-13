package evgenii.goncharov.econome.wallet_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.common_provider.di.api.CommonProviderApi
import evgenii.goncharov.econome.core_database_api.di.CoreDatabaseApi
import evgenii.goncharov.econome.currency.api.CurrencyApi
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import evgenii.goncharov.econome.wallet_impl.di.contracts.WalletCreatorInternal
import evgenii.goncharov.econome.wallet_impl.di.modules.WalletCreatorModule

@FeatureScope
@Component(
    modules = [WalletCreatorModule::class],
    dependencies = [
        CoreDatabaseApi::class,
        CommonProviderApi::class,
        CurrencyApi::class
    ]
)
internal interface WalletCreatorComponent : WalletCreatorInternal {

    @Component.Factory
    interface Factory {

        fun create(
            commonProviderApi: CommonProviderApi,
            coreDatabaseApi: CoreDatabaseApi,
            currencyApi: CurrencyApi,
            @BindsInstance mainNavigationLauncher: MainNavigationLauncher
        ): WalletCreatorComponent
    }
}
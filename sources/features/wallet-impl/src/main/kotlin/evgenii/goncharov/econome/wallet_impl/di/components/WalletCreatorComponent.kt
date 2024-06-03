package evgenii.goncharov.econome.wallet_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.common_provider.di.CommonProviderApi
import evgenii.goncharov.econome.core_database_api.di.CoreDatabaseApi
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import evgenii.goncharov.econome.wallet_impl.di.contracts.WalletCreatorInternal
import evgenii.goncharov.econome.wallet_impl.di.modules.WalletCreatorModule

@FeatureScope
@Component(
    modules = [WalletCreatorModule::class],
    dependencies = [
        CoreDatabaseApi::class,
        CommonProviderApi::class
    ]
)
internal interface WalletCreatorComponent : WalletCreatorInternal {

    @Component.Factory
    interface Factory {

        fun create(
            commonProviderApi: CommonProviderApi,
            coreDatabaseApi: CoreDatabaseApi,
            @BindsInstance mainNavigationLauncher: MainNavigationLauncher
        ): WalletCreatorComponent
    }
}
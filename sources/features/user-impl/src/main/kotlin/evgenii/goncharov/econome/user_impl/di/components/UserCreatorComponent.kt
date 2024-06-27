package evgenii.goncharov.econome.user_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.common_provider.di.api.CommonProviderApi
import evgenii.goncharov.econome.core_database_api.api.CoreDatabaseApi
import evgenii.goncharov.econome.current_user.di.api.CurrentApi
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.user_impl.di.contracts.UserCreatorInternal
import evgenii.goncharov.econome.user_impl.di.modules.UserCreatorBindModule
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher

@FeatureScope
@Component(
    modules = [UserCreatorBindModule::class],
    dependencies = [
        CommonProviderApi::class,
        CoreDatabaseApi::class,
        CurrentApi::class
    ]
)
internal interface UserCreatorComponent : UserCreatorInternal {

    @Component.Factory
    interface Factory {

        fun create(
            coreDatabaseApi: CoreDatabaseApi,
            commonProviderApi: CommonProviderApi,
            currentApi: CurrentApi,
            @BindsInstance walletLauncher: WalletLauncher
        ): UserCreatorComponent
    }
}
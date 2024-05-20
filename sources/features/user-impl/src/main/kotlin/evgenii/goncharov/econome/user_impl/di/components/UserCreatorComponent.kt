package evgenii.goncharov.econome.user_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.common_provider.di.CommonProviderApi
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.user_impl.di.contracts.UserCreatorInternal
import evgenii.goncharov.econome.user_impl.di.modules.UserCreatorBindModule
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher

@FeatureScope
@Component(
    modules = [UserCreatorBindModule::class],
    dependencies = [CommonProviderApi::class]
)
internal interface UserCreatorComponent : UserCreatorInternal {

    @Component.Factory
    interface Factory {

        fun create(
            commonProviderApi: CommonProviderApi,
            @BindsInstance walletLauncher: WalletLauncher
        ): UserCreatorComponent
    }
}
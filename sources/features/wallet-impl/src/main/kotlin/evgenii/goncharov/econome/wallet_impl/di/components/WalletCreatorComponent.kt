package evgenii.goncharov.econome.wallet_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import evgenii.goncharov.econome.wallet_impl.di.contracts.WalletCreatorInternal
import evgenii.goncharov.econome.wallet_impl.di.modules.WalletBindModule

@FeatureScope
@Component(
    modules = [WalletBindModule::class]
)
internal interface WalletCreatorComponent : WalletCreatorInternal {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance mainNavigationLauncher: MainNavigationLauncher
        ): WalletCreatorComponent
    }
}
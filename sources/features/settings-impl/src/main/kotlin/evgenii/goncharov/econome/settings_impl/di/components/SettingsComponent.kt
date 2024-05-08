package evgenii.goncharov.econome.settings_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.settings_impl.di.contracts.SettingsInternal
import evgenii.goncharov.econome.settings_impl.di.modules.SettingsBindsModule
import evgenii.goncharov.econome.user_api.navigation.UserLauncher
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher

@FeatureScope
@Component(
    modules = [SettingsBindsModule::class]
)
internal interface SettingsComponent : SettingsInternal {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance userLauncher: UserLauncher,
            @BindsInstance walletLauncher: WalletLauncher
        ): SettingsComponent
    }
}
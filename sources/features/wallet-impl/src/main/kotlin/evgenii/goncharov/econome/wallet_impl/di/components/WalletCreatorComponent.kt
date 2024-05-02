package evgenii.goncharov.econome.wallet_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.wallet_impl.di.contracts.WalletCreatorInternal
import evgenii.goncharov.econome.wallet_impl.di.modules.WalletViewModelBindsModule

@FeatureScope
@Component(
    modules = [WalletViewModelBindsModule::class]
)
internal interface WalletCreatorComponent : WalletCreatorInternal {

    @Component.Factory
    interface Factory {

        fun create(): WalletCreatorComponent
    }
}
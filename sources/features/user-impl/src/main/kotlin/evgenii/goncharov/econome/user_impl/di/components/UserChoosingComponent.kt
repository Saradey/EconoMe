package evgenii.goncharov.econome.user_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.user_impl.di.contracts.UserChoosingInternal
import evgenii.goncharov.econome.user_impl.di.modules.UserViewModelBindsModule
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher

@FeatureScope
@Component(
    modules = [UserViewModelBindsModule::class]
)
internal interface UserChoosingComponent : UserChoosingInternal {

    @Component.Factory
    interface Factory {

        fun create(): UserChoosingComponent
    }
}
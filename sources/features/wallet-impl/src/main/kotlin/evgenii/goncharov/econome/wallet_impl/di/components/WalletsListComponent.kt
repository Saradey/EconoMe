package evgenii.goncharov.econome.wallet_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.wallet_impl.di.contracts.WalletsListInternal
import evgenii.goncharov.econome.wallet_impl.di.modules.WalletsListBindModule

@FeatureScope
@Component(
    modules = [WalletsListBindModule::class]
)
internal interface WalletsListComponent : WalletsListInternal {

    @Component.Factory
    interface Factory {

        fun create(): WalletsListComponent
    }
}
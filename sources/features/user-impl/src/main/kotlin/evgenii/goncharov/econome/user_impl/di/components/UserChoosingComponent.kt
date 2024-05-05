package evgenii.goncharov.econome.user_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.user_impl.di.contracts.UserChoosingInternal
import evgenii.goncharov.econome.user_impl.di.modules.UserChoosingViewModelBindsModule

@FeatureScope
@Component(
    modules = [UserChoosingViewModelBindsModule::class]
)
internal interface UserChoosingComponent : UserChoosingInternal {

    @Component.Factory
    interface Factory {

        fun create(): UserChoosingComponent
    }
}
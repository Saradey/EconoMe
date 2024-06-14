package evgenii.goncharov.econome.current_user.di

import dagger.Component
import evgenii.goncharov.econome.current_user.di.api.CurrentApi
import evgenii.goncharov.econome.current_user.di.modules.CurrentBindsModule
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@CoreScope
@Component(
    modules = [
        CurrentBindsModule::class
    ]
)
internal interface CurrentComponent : CurrentApi {

    @Component.Factory
    interface Factory {

        fun create(): CurrentComponent
    }
}
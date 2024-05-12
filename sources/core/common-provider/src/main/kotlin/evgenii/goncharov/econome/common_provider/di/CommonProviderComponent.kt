package evgenii.goncharov.econome.common_provider.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.common_provider.di.modules.CommonProviderBindModule
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@CoreScope
@Component(
    modules = [CommonProviderBindModule::class]
)
internal interface CommonProviderComponent : CommonProviderApi {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance appContext: Context): CommonProviderComponent
    }
}
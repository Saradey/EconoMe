package evgenii.goncharov.econome.common_provider

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.common_provider.modules.CommonProviderBindModule
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@CoreScope
@Component(
    dependencies = [CommonProviderBindModule::class]
)
internal interface CommonProviderComponent : CommonProviderApi {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance appContext: Context): CommonProviderComponent
    }
}
package evgenii.goncharov.econome.common_provider

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@CoreScope
@Component
internal interface CommonProviderComponent : CommonProviderApi{
}
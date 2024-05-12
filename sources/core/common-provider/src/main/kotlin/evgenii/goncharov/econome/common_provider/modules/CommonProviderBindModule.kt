package evgenii.goncharov.econome.common_provider.modules

import dagger.Binds
import dagger.Module
import evgenii.goncharov.econome.common_provider.managers.ResourceManager
import evgenii.goncharov.econome.common_provider.managers.impl.ResourceManagerImpl
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@Module
internal interface CommonProviderBindModule {
    
    @CoreScope
    @Binds
    fun bindResourceManager(manager: ResourceManagerImpl) : ResourceManager
}
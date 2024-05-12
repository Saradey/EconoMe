package evgenii.goncharov.econome.common_provider.di.modules

import dagger.Binds
import dagger.Module
import evgenii.goncharov.econome.common_provider.managers.AuthManager
import evgenii.goncharov.econome.common_provider.managers.ResourceManager
import evgenii.goncharov.econome.common_provider.managers.impl.AuthManagerImpl
import evgenii.goncharov.econome.common_provider.managers.impl.ResourceManagerImpl
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@Module
internal interface CommonProviderBindModule {

    @CoreScope
    @Binds
    fun bindResourceManager(manager: ResourceManagerImpl): ResourceManager

    @CoreScope
    @Binds
    fun bindAuthManager(manager: AuthManagerImpl): AuthManager
}
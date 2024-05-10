package evgenii.goncharov.econome.core_database_impl.di

import dagger.Component
import evgenii.goncharov.econome.common_provider.CommonProviderApi
import evgenii.goncharov.econome.core_database_api.di.CoreDatabaseApi
import evgenii.goncharov.econome.core_database_impl.di.modules.CoreDatabaseProvideModule
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@CoreScope
@Component(
    modules = [CoreDatabaseProvideModule::class],
    dependencies = [CommonProviderApi::class]
)
internal interface CoreDatabaseComponent : CoreDatabaseApi
package evgenii.goncharov.econome.core_database_impl.di

import dagger.Component
import evgenii.goncharov.econome.common_provider.di.api.CommonProviderApi
import evgenii.goncharov.econome.core_database_api.api.CoreDatabaseApi
import evgenii.goncharov.econome.core_database_impl.di.modules.CoreDatabaseBindModule
import evgenii.goncharov.econome.core_database_impl.di.modules.CoreDatabaseProvideModule
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@CoreScope
@Component(
    modules = [
        CoreDatabaseProvideModule::class,
        CoreDatabaseBindModule::class
    ],
    dependencies = [CommonProviderApi::class]
)
internal interface CoreDatabaseComponent : CoreDatabaseApi
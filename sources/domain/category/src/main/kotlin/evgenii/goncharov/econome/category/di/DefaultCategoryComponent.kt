package evgenii.goncharov.econome.category.di

import dagger.Component
import evgenii.goncharov.econome.category.api.DefaultCategoryApi
import evgenii.goncharov.econome.category.di.modules.DefaultCategoryBindsModule
import evgenii.goncharov.econome.common_provider.di.api.CommonProviderApi
import evgenii.goncharov.econome.core_database_api.api.CoreDatabaseApi
import evgenii.goncharov.econome.di_core.di.scopes.CoreScope

@CoreScope
@Component(
    dependencies = [
        CommonProviderApi::class,
        CoreDatabaseApi::class
    ],
    modules = [DefaultCategoryBindsModule::class]
)
internal interface DefaultCategoryComponent : DefaultCategoryApi {

    @Component.Factory
    interface Factory {

        fun create(
            commonProviderApi: CommonProviderApi,
            coreDatabaseApi: CoreDatabaseApi
        ): DefaultCategoryComponent
    }
}
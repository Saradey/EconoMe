package evgenii.goncharov.econome.spending_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.category.api.DefaultCategoryApi
import evgenii.goncharov.econome.common_provider.di.api.CommonProviderApi
import evgenii.goncharov.econome.core_database_api.api.CoreDatabaseApi
import evgenii.goncharov.econome.current_user.di.api.CurrentApi
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.spending_impl.di.contracts.SpendingInfoInternal
import evgenii.goncharov.econome.spending_impl.di.modules.SpendingInfoBindModule

@FeatureScope
@Component(
    dependencies = [
        CoreDatabaseApi::class,
        CommonProviderApi::class,
        DefaultCategoryApi::class,
        CurrentApi::class
    ],
    modules = [SpendingInfoBindModule::class]
)
internal interface SpendingInfoComponent : SpendingInfoInternal {

    @Component.Factory
    interface Factory {

        fun create(
            currentApi: CurrentApi,
            defaultCategoryApi: DefaultCategoryApi,
            commonProviderApi: CommonProviderApi,
            coreDatabaseApi: CoreDatabaseApi,
            @BindsInstance spendingId: Long
        ): SpendingInfoComponent
    }
}
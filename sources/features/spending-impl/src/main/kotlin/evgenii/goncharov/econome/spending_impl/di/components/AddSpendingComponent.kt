package evgenii.goncharov.econome.spending_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.category.api.DefaultCategoryApi
import evgenii.goncharov.econome.core_database_api.api.CoreDatabaseApi
import evgenii.goncharov.econome.current_user.di.api.CurrentApi
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.spending_impl.di.contracts.AddSpendingInternal
import evgenii.goncharov.econome.spending_impl.di.modules.AddSpendingBindModule

@FeatureScope
@Component(
    dependencies = [
        CoreDatabaseApi::class,
        DefaultCategoryApi::class,
        CurrentApi::class
    ],
    modules = [AddSpendingBindModule::class]
)
internal interface AddSpendingComponent : AddSpendingInternal {

    @Component.Factory
    interface Factory {

        fun create(
            coreDatabaseApi: CoreDatabaseApi,
            defaultCategoryApi: DefaultCategoryApi,
            currentApi: CurrentApi
        ): AddSpendingComponent
    }
}
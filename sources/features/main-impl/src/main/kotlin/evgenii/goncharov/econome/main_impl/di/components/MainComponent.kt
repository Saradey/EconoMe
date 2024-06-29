package evgenii.goncharov.econome.main_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.common_provider.di.api.CommonProviderApi
import evgenii.goncharov.econome.core_database_api.api.CoreDatabaseApi
import evgenii.goncharov.econome.current_user.di.api.CurrentApi
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_api.navigation.MainLauncher
import evgenii.goncharov.econome.main_impl.di.contracts.MainInternal
import evgenii.goncharov.econome.main_impl.di.modules.MainBindModule
import evgenii.goncharov.econome.product_cost_analysis_api.navigation.ProductCostAnalysisLauncher
import evgenii.goncharov.econome.spending_api.navigation.SpendingLauncher

@FeatureScope
@Component(
    dependencies = [
        CurrentApi::class,
        CoreDatabaseApi::class,
        CommonProviderApi::class
    ],
    modules = [MainBindModule::class]
)
internal interface MainComponent : MainInternal {

    @Component.Factory
    interface Factory {

        fun create(
            commonProviderApi: CommonProviderApi,
            coreDatabaseApi: CoreDatabaseApi,
            currentApi: CurrentApi,
            @BindsInstance spendingLauncher: SpendingLauncher,
            @BindsInstance mainLauncher: MainLauncher,
            @BindsInstance productCostAnalysisLauncher: ProductCostAnalysisLauncher
        ): MainComponent
    }
}
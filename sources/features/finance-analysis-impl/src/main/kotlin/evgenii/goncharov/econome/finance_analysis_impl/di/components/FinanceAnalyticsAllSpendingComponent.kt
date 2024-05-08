package evgenii.goncharov.econome.finance_analysis_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.finance_analysis_api.navigation.FinanceAnalyticsAllSpendingLauncher
import evgenii.goncharov.econome.finance_analysis_impl.di.contracts.FinanceAnalyticsAllSpendingInternal
import evgenii.goncharov.econome.finance_analysis_impl.di.modules.FinanceAnalyticsAllSpendingViewModelBindsModule

@FeatureScope
@Component(
    modules = [
        FinanceAnalyticsAllSpendingViewModelBindsModule::class
    ]
)
internal interface FinanceAnalyticsAllSpendingComponent : FinanceAnalyticsAllSpendingInternal {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance launcher: FinanceAnalyticsAllSpendingLauncher
        ): FinanceAnalyticsAllSpendingComponent
    }
}
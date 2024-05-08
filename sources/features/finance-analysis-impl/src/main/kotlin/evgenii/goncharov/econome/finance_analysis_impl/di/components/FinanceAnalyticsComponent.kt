package evgenii.goncharov.econome.finance_analysis_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.finance_analysis_impl.di.contracts.FinanceAnalyticsInternal
import evgenii.goncharov.econome.finance_analysis_impl.di.modules.FinanceAnalyticsBindsModule

@FeatureScope
@Component(
    modules = [
        FinanceAnalyticsBindsModule::class
    ]
)
internal interface FinanceAnalyticsComponent : FinanceAnalyticsInternal {

    @Component.Factory
    interface Factory {

        fun create(): FinanceAnalyticsComponent
    }
}
package evgenii.goncharov.econome.finance_analysis_impl.di.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.finance_analysis_api.di.FinanceAnalyticsApi
import evgenii.goncharov.econome.finance_analysis_impl.di.components.DaggerFinanceAnalyticsComponent
import javax.inject.Inject

public class FinanceAnalyticsHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<FinanceAnalyticsApi>(container) {

    override fun buildComponent(): FinanceAnalyticsApi {
        return DaggerFinanceAnalyticsComponent.factory().create()
    }
}
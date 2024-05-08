package evgenii.goncharov.econome.finance_analysis_impl.di.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.finance_analysis_api.di.FinanceAnalyticsAllSpendingApi
import evgenii.goncharov.econome.finance_analysis_api.navigation.FinanceAnalyticsAllSpendingLauncher
import evgenii.goncharov.econome.finance_analysis_impl.di.components.DaggerFinanceAnalyticsAllSpendingComponent
import javax.inject.Inject

public class FinanceAnalyticsAllSpendingHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<FinanceAnalyticsAllSpendingApi>(container) {

    override fun buildComponent(): FinanceAnalyticsAllSpendingApi {
        return DaggerFinanceAnalyticsAllSpendingComponent.factory().create(
            launcher = getFeatureLauncher(FinanceAnalyticsAllSpendingLauncher::class.java)
        )
    }
}

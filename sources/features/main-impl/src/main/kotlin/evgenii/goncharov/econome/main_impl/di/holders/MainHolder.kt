package evgenii.goncharov.econome.main_impl.di.holders

import evgenii.goncharov.econome.current_user.di.api.CurrentApi
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.main_api.di.MainApi
import evgenii.goncharov.econome.main_api.navigation.MainLauncher
import evgenii.goncharov.econome.main_impl.di.components.DaggerMainComponent
import evgenii.goncharov.econome.product_cost_analysis_api.navigation.ProductCostAnalysisLauncher
import evgenii.goncharov.econome.spending_api.navigation.SpendingLauncher
import javax.inject.Inject

public class MainHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<MainApi>(container) {

    override fun buildComponent(): MainApi {
        return DaggerMainComponent.factory().create(
            currentApi = getGlobalComponent(CurrentApi::class.java),
            spendingLauncher = getFeatureLauncher(SpendingLauncher::class.java),
            mainLauncher = getFeatureLauncher(MainLauncher::class.java),
            productCostAnalysisLauncher = getFeatureLauncher(ProductCostAnalysisLauncher::class.java),
        )
    }
}
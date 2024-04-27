package evgenii.goncharov.econome.all_spending_impl.di.holders

import evgenii.goncharov.econome.all_spending_api.di.AllSpendingApi
import evgenii.goncharov.econome.all_spending_impl.di.components.DaggerAllSpendingComponent
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import javax.inject.Inject

public class AllSpendingHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<AllSpendingApi>(container) {

    override fun buildComponent(): AllSpendingApi {
        return DaggerAllSpendingComponent.factory().create()
    }
}
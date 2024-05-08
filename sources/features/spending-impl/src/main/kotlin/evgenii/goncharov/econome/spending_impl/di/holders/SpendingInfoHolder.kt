package evgenii.goncharov.econome.spending_impl.di.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.spending_api.di.SpendingInfoApi
import evgenii.goncharov.econome.spending_impl.di.components.DaggerSpendingInfoComponent
import javax.inject.Inject

public class SpendingInfoHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<SpendingInfoApi>(container) {

    override fun buildComponent(): SpendingInfoApi {
        return DaggerSpendingInfoComponent.factory().create()
    }
}
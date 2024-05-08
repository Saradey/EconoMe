package evgenii.goncharov.econome.main_impl.di.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.main_api.di.SpendingLimitApi
import evgenii.goncharov.econome.main_impl.di.components.DaggerSpendingLimitComponent
import javax.inject.Inject

public class SpendingLimitHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<SpendingLimitApi>(container) {

    override fun buildComponent(): SpendingLimitApi {
        return DaggerSpendingLimitComponent.factory().create()
    }
}
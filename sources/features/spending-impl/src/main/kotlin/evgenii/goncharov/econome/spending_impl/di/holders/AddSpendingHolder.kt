package evgenii.goncharov.econome.spending_impl.di.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.spending_api.di.AddSpendingApi
import evgenii.goncharov.econome.spending_impl.di.components.DaggerAddSpendingComponent
import javax.inject.Inject

public class AddSpendingHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<AddSpendingApi>(container) {

    override fun buildComponent(): AddSpendingApi {
        return DaggerAddSpendingComponent.factory().create()
    }
}
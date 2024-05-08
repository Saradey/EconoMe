package evgenii.goncharov.econome.bank_accounts_impl.di.holders

import evgenii.goncharov.econome.bank_accounts_api.di.AddStateAccountApi
import evgenii.goncharov.econome.bank_accounts_impl.di.components.DaggerAddStateAccountComponent
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import javax.inject.Inject

public class AddStateAccountHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<AddStateAccountApi>(container) {

    override fun buildComponent(): AddStateAccountApi {
        return DaggerAddStateAccountComponent.factory().create()
    }
}
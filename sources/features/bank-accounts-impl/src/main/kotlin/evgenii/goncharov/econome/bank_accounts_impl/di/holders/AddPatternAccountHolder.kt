package evgenii.goncharov.econome.bank_accounts_impl.di.holders

import evgenii.goncharov.econome.bank_accounts_api.di.AddPatternAccountApi
import evgenii.goncharov.econome.bank_accounts_impl.di.components.DaggerAddPatternAccountComponent
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import javax.inject.Inject

public class AddPatternAccountHolder  @Inject constructor(container: FeatureContainer) :
    FeatureHolder<AddPatternAccountApi>(container) {

    override fun buildComponent(): AddPatternAccountApi {
        return DaggerAddPatternAccountComponent.factory().create()
    }
}
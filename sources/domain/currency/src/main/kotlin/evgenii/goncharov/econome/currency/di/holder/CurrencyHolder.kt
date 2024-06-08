package evgenii.goncharov.econome.currency.di.holder

import evgenii.goncharov.econome.common_provider.di.CommonProviderApi
import evgenii.goncharov.econome.currency.api.CurrencyApi
import evgenii.goncharov.econome.currency.di.DaggerCurrencyComponent
import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager
import evgenii.goncharov.econome.di_core.holders.BaseHolder
import javax.inject.Inject

public class CurrencyHolder @Inject constructor(
    featureContainer: FeatureContainerManager
) : BaseHolder<CurrencyApi>(featureContainer) {

    override fun buildComponent(): CurrencyApi {
        return DaggerCurrencyComponent.factory().create(
            commonProviderApi = getGlobalComponent(CommonProviderApi::class.java)
        )
    }
}
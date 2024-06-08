package evgenii.goncharov.econome.currency.di.holder

import android.content.Context
import evgenii.goncharov.econome.currency.api.CurrencyApi
import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager
import evgenii.goncharov.econome.di_core.holders.BaseHolder
import javax.inject.Inject

public class CurrencyHolder @Inject constructor(
    featureContainer: FeatureContainerManager,
    private val appContext: Context
) : BaseHolder<CurrencyApi>(featureContainer) {

    override fun buildComponent(): CurrencyApi {
        TODO("Not yet implemented")
    }
}
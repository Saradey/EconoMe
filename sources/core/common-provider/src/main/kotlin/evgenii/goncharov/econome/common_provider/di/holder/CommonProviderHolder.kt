package evgenii.goncharov.econome.common_provider.di.holder

import android.content.Context
import evgenii.goncharov.econome.common_provider.di.DaggerCommonProviderComponent
import evgenii.goncharov.econome.common_provider.di.api.CommonProviderApi
import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager
import evgenii.goncharov.econome.di_core.holders.BaseHolder
import javax.inject.Inject

public class CommonProviderHolder @Inject constructor(
    featureContainer: FeatureContainerManager,
    private val appContext: Context
) : BaseHolder<CommonProviderApi>(featureContainer) {

    override fun buildComponent(): CommonProviderApi {
        return DaggerCommonProviderComponent.factory().create(
            appContext = appContext
        )
    }
}
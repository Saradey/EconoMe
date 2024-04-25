package evgenii.goncharov.econome.navigation.holder

import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager
import evgenii.goncharov.econome.di_core.holders.BaseHolder
import evgenii.goncharov.econome.navigation.DaggerCoreNavigationComponent
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi
import javax.inject.Inject

public class NavigationHolder @Inject constructor(
    featureContainer: FeatureContainerManager
) : BaseHolder<CoreNavigationApi>(featureContainer) {

    override fun buildComponent(): CoreNavigationApi {
        return DaggerCoreNavigationComponent.create()
    }
}
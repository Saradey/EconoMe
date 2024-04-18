package evgenii.goncharov.econome.di.holder

import evgenii.goncharov.econome.di.DaggerLaunchersComponent
import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager
import evgenii.goncharov.econome.di_core.contracts.LaunchersApi
import evgenii.goncharov.econome.di_core.holders.BaseHolder
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi

class LaunchersHolder(
    container: FeatureContainerManager
) : BaseHolder<LaunchersApi>(container) {

    override fun buildComponent(): LaunchersApi {
        return DaggerLaunchersComponent.builder()
            .coreNavigationApi(getGlobalComponent(CoreNavigationApi::class.java))
            .build()
    }
}
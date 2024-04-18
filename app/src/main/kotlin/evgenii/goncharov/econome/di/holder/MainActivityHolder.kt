package evgenii.goncharov.econome.di.holder

import evgenii.goncharov.econome.di.DaggerMainActivityComponent
import evgenii.goncharov.econome.di.contracts.MainActivityApi
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi

class MainActivityHolder(container: FeatureContainer) :
    FeatureHolder<MainActivityApi>(container) {

    override fun buildComponent(): MainActivityApi {
        return DaggerMainActivityComponent.factory().create(
            coreNavigationApi = getGlobalComponent(CoreNavigationApi::class.java)
        )
    }
}
package evgenii.goncharov.econome.di.holder

import evgenii.goncharov.econome.di.contracts.MainActivityApi
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder

class MainActivityHolder(container: FeatureContainer) :
    FeatureHolder<MainActivityApi>(container) {

    override fun buildComponent(): MainActivityApi {

    }
}
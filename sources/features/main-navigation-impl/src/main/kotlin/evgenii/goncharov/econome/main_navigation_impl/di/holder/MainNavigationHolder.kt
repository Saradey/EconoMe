package evgenii.goncharov.econome.main_navigation_impl.di.holder

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.main_navigation.di.MainNavigationApi
import evgenii.goncharov.econome.main_navigation_impl.di.components.DaggerMainNavigationComponent
import javax.inject.Inject

public class MainNavigationHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<MainNavigationApi>(container) {

    override fun buildComponent(): MainNavigationApi {
        return DaggerMainNavigationComponent.factory().create()
    }
}
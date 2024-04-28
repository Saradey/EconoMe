package evgenii.goncharov.econome.main_impl.di.holders

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.main_api.di.MainApi
import evgenii.goncharov.econome.main_impl.di.components.DaggerMainComponent
import javax.inject.Inject

public class MainHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<MainApi>(container) {

    override fun buildComponent(): MainApi {
        return DaggerMainComponent.factory().create()
    }
}
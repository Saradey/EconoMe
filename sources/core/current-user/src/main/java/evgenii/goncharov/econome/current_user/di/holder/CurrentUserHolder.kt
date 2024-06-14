package evgenii.goncharov.econome.current_user.di.holder

import evgenii.goncharov.econome.current_user.di.DaggerCurrentComponent
import evgenii.goncharov.econome.current_user.di.api.CurrentApi
import evgenii.goncharov.econome.di_core.containers.FeatureContainerManager
import evgenii.goncharov.econome.di_core.holders.BaseHolder
import javax.inject.Inject

public class CurrentUserHolder @Inject constructor(
    featureContainer: FeatureContainerManager,
) : BaseHolder<CurrentApi>(featureContainer) {

    override fun buildComponent(): CurrentApi {
        return DaggerCurrentComponent.factory().create()
    }
}
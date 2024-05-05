package evgenii.goncharov.econome.user_impl.di.holder

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import evgenii.goncharov.econome.user_api.di.UserChoosingApi
import evgenii.goncharov.econome.user_impl.di.components.DaggerUserChoosingComponent
import javax.inject.Inject

public class UserChoosingHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<UserChoosingApi>(container) {

    override fun buildComponent(): UserChoosingApi {
        return DaggerUserChoosingComponent.factory().create(
            mainNavigationLauncher = getFeatureLauncher(MainNavigationLauncher::class.java)
        )
    }
}
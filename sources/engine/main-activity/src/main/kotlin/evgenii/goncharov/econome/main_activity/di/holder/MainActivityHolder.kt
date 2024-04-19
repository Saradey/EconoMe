package evgenii.goncharov.econome.main_activity.di.holder

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.main_activity.di.DaggerMainActivityComponent
import evgenii.goncharov.econome.main_activity.di.contracts.MainActivityApi
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi
import evgenii.goncharov.econome.user_api.UserLauncher
import javax.inject.Inject

public class MainActivityHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<MainActivityApi>(container) {

    override fun buildComponent(): MainActivityApi {
        return DaggerMainActivityComponent.factory().create(
            coreNavigationApi = getGlobalComponent(CoreNavigationApi::class.java),
            userLauncher = getFeatureLauncher(UserLauncher::class.java)
        )
    }
}
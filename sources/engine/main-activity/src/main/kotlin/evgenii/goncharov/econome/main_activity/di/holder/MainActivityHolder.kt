package evgenii.goncharov.econome.main_activity.di.holder

import evgenii.goncharov.econome.core_database_api.di.CoreDatabaseApi
import evgenii.goncharov.econome.current_user.di.api.CurrentApi
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.main_activity.di.DaggerMainActivityComponent
import evgenii.goncharov.econome.main_activity.di.contracts.MainActivityApi
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi
import evgenii.goncharov.econome.user_api.navigation.UserLauncher
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher
import javax.inject.Inject

public class MainActivityHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<MainActivityApi>(container) {

    override fun buildComponent(): MainActivityApi {
        return DaggerMainActivityComponent.factory().create(
            coreDatabaseApi = getGlobalComponent(CoreDatabaseApi::class.java),
            coreNavigationApi = getGlobalComponent(CoreNavigationApi::class.java),
            currentApi = getGlobalComponent(CurrentApi::class.java),
            userLauncher = getFeatureLauncher(UserLauncher::class.java),
            mainNavigationLauncher = getFeatureLauncher(MainNavigationLauncher::class.java),
            walletLauncher = getFeatureLauncher(WalletLauncher::class.java)
        )
    }
}
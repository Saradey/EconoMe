package evgenii.goncharov.econome.user_impl.di.holder

import evgenii.goncharov.econome.common_provider.di.api.CommonProviderApi
import evgenii.goncharov.econome.core_database_api.api.CoreDatabaseApi
import evgenii.goncharov.econome.current_user.di.api.CurrentApi
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.user_api.di.UserCreatorApi
import evgenii.goncharov.econome.user_impl.di.components.DaggerUserCreatorComponent
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher
import javax.inject.Inject

public class UserCreatorHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<UserCreatorApi>(container) {

    override fun buildComponent(): UserCreatorApi {
        return DaggerUserCreatorComponent.factory().create(
            coreDatabaseApi = getGlobalComponent(CoreDatabaseApi::class.java),
            commonProviderApi = getGlobalComponent(CommonProviderApi::class.java),
            currentApi = getGlobalComponent(CurrentApi::class.java),
            walletLauncher = getFeatureLauncher(WalletLauncher::class.java)
        )
    }
}
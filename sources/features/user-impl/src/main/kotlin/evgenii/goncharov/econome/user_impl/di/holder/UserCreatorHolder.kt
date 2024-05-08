package evgenii.goncharov.econome.user_impl.di.holder

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
            walletLauncher = getFeatureLauncher(WalletLauncher::class.java)
        )
    }
}
package evgenii.goncharov.econome.settings_impl.di.holder

import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.settings_api.di.SettingsApi
import evgenii.goncharov.econome.settings_impl.di.components.DaggerSettingsComponent
import evgenii.goncharov.econome.user_api.navigation.UserLauncher
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher
import javax.inject.Inject

public class SettingsHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<SettingsApi>(container) {

    override fun buildComponent(): SettingsApi {
        return DaggerSettingsComponent.factory().create(
            userLauncher = getFeatureLauncher(UserLauncher::class.java),
            walletLauncher = getFeatureLauncher(WalletLauncher::class.java)
        )
    }
}
package evgenii.goncharov.econome.wallet_impl.di.holder

import evgenii.goncharov.econome.common_provider.di.CommonProviderApi
import evgenii.goncharov.econome.core_database_api.di.CoreDatabaseApi
import evgenii.goncharov.econome.currency.api.CurrencyApi
import evgenii.goncharov.econome.di_core.containers.FeatureContainer
import evgenii.goncharov.econome.di_core.holders.FeatureHolder
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import evgenii.goncharov.econome.wallet_api.di.WalletCreatorApi
import evgenii.goncharov.econome.wallet_impl.di.components.DaggerWalletCreatorComponent
import javax.inject.Inject

public class WalletCreatorHolder @Inject constructor(container: FeatureContainer) :
    FeatureHolder<WalletCreatorApi>(container) {

    override fun buildComponent(): WalletCreatorApi {
        return DaggerWalletCreatorComponent.factory().create(
            commonProviderApi = getGlobalComponent(CommonProviderApi::class.java),
            coreDatabaseApi = getGlobalComponent(CoreDatabaseApi::class.java),
            currencyApi = getGlobalComponent(CurrencyApi::class.java),
            mainNavigationLauncher = getFeatureLauncher(MainNavigationLauncher::class.java)
        )
    }
}
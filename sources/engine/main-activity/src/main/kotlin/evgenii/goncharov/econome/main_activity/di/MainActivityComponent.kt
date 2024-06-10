package evgenii.goncharov.econome.main_activity.di

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.core_database_api.di.CoreDatabaseApi
import evgenii.goncharov.econome.main_activity.di.contracts.MainActivityInternal
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_activity.di.modules.MainActivityBindsModule
import evgenii.goncharov.econome.main_navigation.navigation.MainNavigationLauncher
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi
import evgenii.goncharov.econome.user_api.navigation.UserLauncher
import evgenii.goncharov.econome.wallet_api.navigation.WalletLauncher

@FeatureScope
@Component(
    dependencies = [
        CoreNavigationApi::class,
        CoreDatabaseApi::class
    ],
    modules = [MainActivityBindsModule::class]
)
internal interface MainActivityComponent : MainActivityInternal {

    @Component.Factory
    interface Factory {

        fun create(
            coreDatabaseApi: CoreDatabaseApi,
            coreNavigationApi: CoreNavigationApi,
            @BindsInstance userLauncher: UserLauncher,
            @BindsInstance mainNavigationLauncher: MainNavigationLauncher,
            @BindsInstance walletLauncher: WalletLauncher
        ): MainActivityComponent
    }
}
package evgenii.goncharov.econome.main_activity.di

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.main_activity.di.contracts.MainActivityInternal
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_activity.di.modules.MainActivityBindsModule
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi
import evgenii.goncharov.econome.user_api.UserLauncher

@FeatureScope
@Component(
    dependencies = [CoreNavigationApi::class],
    modules = [MainActivityBindsModule::class]
)
internal interface MainActivityComponent : MainActivityInternal {

    @Component.Factory
    interface Factory {
        fun create(
            coreNavigationApi: CoreNavigationApi,
            @BindsInstance userLauncher: UserLauncher
        ): MainActivityComponent
    }
}
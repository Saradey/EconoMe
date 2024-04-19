package evgenii.goncharov.econome.di

import dagger.Component
import evgenii.goncharov.econome.di.contracts.MainActivityInternal
import evgenii.goncharov.econome.di.modules.MainActivityBindsModule
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.navigation.api.CoreNavigationApi

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
        ): MainActivityComponent
    }
}
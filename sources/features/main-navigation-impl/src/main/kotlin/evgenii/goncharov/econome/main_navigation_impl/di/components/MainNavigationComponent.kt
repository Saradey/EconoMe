package evgenii.goncharov.econome.main_navigation_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_navigation_impl.di.contracts.MainNavigationInternal
import evgenii.goncharov.econome.main_navigation_impl.di.modules.MainNavigationViewModelBindsModule

@FeatureScope
@Component(
    modules = [MainNavigationViewModelBindsModule::class]
)
internal interface MainNavigationComponent : MainNavigationInternal {

    @Component.Factory
    interface Factory {

        fun create(): MainNavigationComponent
    }
}
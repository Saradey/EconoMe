package evgenii.goncharov.econome.main_impl.di.components

import dagger.BindsInstance
import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_api.navigation.MainLauncher
import evgenii.goncharov.econome.main_impl.di.contracts.MainInternal
import evgenii.goncharov.econome.main_impl.di.modules.MainViewModelBindsModule
import evgenii.goncharov.econome.spending_api.navigation.SpendingLauncher

@FeatureScope
@Component(
    modules = [MainViewModelBindsModule::class]
)
internal interface MainComponent : MainInternal {

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance spendingLauncher: SpendingLauncher,
            @BindsInstance mainLauncher: MainLauncher
        ): MainComponent
    }
}
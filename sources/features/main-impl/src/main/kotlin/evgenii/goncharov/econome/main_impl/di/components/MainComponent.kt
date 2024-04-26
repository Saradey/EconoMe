package evgenii.goncharov.econome.main_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.main_impl.di.contracts.MainInternal
import evgenii.goncharov.econome.main_impl.di.modules.MainViewModelBindsModule

@Component(
    modules = [MainViewModelBindsModule::class]
)
internal interface MainComponent : MainInternal {

    @Component.Factory
    interface Factory {

        fun create(): MainComponent
    }
}
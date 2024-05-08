package evgenii.goncharov.econome.settings_impl.di.components

import dagger.Component
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.settings_impl.di.contracts.SettingsInternal
import evgenii.goncharov.econome.settings_impl.di.modules.SettingsBindsModule

@FeatureScope
@Component(
    modules = [SettingsBindsModule::class]
)
internal interface SettingsComponent : SettingsInternal {

    @Component.Factory
    interface Factory {

        fun create(): SettingsComponent
    }
}
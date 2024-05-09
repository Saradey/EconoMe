package evgenii.goncharov.econome.settings_impl.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.settings_impl.view.models.SettingsViewModel

@Module(includes = [MultiViewModelModule::class])
internal interface SettingsBindsModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(SettingsViewModel::class)]
    fun bindSettingsViewModel(viewModel: SettingsViewModel): ViewModel
}
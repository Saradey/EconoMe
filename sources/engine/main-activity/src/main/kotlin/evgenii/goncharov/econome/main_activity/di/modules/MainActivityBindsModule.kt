package evgenii.goncharov.econome.main_activity.di.modules

import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.main_activity.MainActivityViewModel
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_activity.navigation.MainOnBackPressed

@Module(includes = [MultiViewModelModule::class])
internal interface MainActivityBindsModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(MainActivityViewModel::class)]
    fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @[Binds FeatureScope]
    fun bindMainOnBackPressed(back: MainOnBackPressed): OnBackPressedCallback
}
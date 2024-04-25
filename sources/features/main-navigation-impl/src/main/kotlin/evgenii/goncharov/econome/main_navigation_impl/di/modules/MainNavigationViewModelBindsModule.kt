package evgenii.goncharov.econome.main_navigation_impl.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.MultiViewModelFactory
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_navigation_impl.view.models.MainNavigationViewModel

@Module
internal interface MainNavigationViewModelBindsModule {

    @[Binds FeatureScope]
    fun bindMultiViewModelFactory(factory: MultiViewModelFactory): ViewModelProvider.Factory

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(MainNavigationViewModel::class)]
    fun bindUserCreatorViewModel(viewModel: MainNavigationViewModel): ViewModel
}
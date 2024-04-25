package evgenii.goncharov.econome.user_impl.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.MultiViewModelFactory
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.user_impl.view.models.UserCreatorViewModel

@Module
internal interface UserViewModelBindsModule {

    @[Binds FeatureScope]
    fun provideMultiViewModelFactory(factory: MultiViewModelFactory): ViewModelProvider.Factory

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(UserCreatorViewModel::class)]
    fun provideMainActivityViewModel(viewModel: UserCreatorViewModel): ViewModel
}
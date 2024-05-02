package evgenii.goncharov.econome.user_impl.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.user_impl.view.models.UserChoosingViewModel
import evgenii.goncharov.econome.user_impl.view.models.UserCreatorViewModel

@Module(includes = [MultiViewModelModule::class])
internal interface UserViewModelBindsModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(UserCreatorViewModel::class)]
    fun bindUserCreatorViewModel(viewModel: UserCreatorViewModel): ViewModel

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(UserChoosingViewModel::class)]
    fun bindUserChoosingViewModel(viewModel: UserChoosingViewModel): ViewModel
}
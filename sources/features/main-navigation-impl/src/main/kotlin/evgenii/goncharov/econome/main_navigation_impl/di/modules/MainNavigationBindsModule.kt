package evgenii.goncharov.econome.main_navigation_impl.di.modules

import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.main_navigation_impl.navigation.BottomMenuOnBackPressed
import evgenii.goncharov.econome.main_navigation_impl.view.models.MainNavigationViewModel

@Module(includes = [MultiViewModelModule::class])
internal interface MainNavigationBindsModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(MainNavigationViewModel::class)]
    fun bindUserCreatorViewModel(viewModel: MainNavigationViewModel): ViewModel

    @FeatureScope
    @Binds
    fun bindBottomMenuOnBackPressed(onBackPressed: BottomMenuOnBackPressed): OnBackPressedCallback
}
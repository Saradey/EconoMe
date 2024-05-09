package evgenii.goncharov.econome.common_categories_impl.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.common_categories_impl.view.models.AllCategoriesViewModel
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope

@Module(includes = [MultiViewModelModule::class])
internal interface AllCategoriesBindModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(AllCategoriesViewModel::class)]
    fun bindAllCategoriesViewModel(viewModel: AllCategoriesViewModel): ViewModel
}
package evgenii.goncharov.econome.product_categories_impl.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.product_categories_impl.view.models.AddProductViewModel

@Module(includes = [MultiViewModelModule::class])
internal interface AddProductBindModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(AddProductViewModel::class)]
    fun bindAddProductViewModel(viewModel: AddProductViewModel): ViewModel
}
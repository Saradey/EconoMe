package evgenii.goncharov.econome.product_cost_analysis_impl.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.product_cost_analysis_impl.view.models.AddShopViewModel

@Module(includes = [MultiViewModelModule::class])
internal interface AddShopBindModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(AddShopViewModel::class)]
    fun bindAppShopViewModel(viewModel: AddShopViewModel): ViewModel
}
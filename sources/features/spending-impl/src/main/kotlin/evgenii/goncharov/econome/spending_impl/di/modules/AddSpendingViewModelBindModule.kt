package evgenii.goncharov.econome.spending_impl.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.spending_impl.view.models.AddSpendingViewModel

@Module(includes = [MultiViewModelModule::class])
internal interface AddSpendingViewModelBindModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(AddSpendingViewModel::class)]
    fun bindAddSpendingViewModel(viewModel: AddSpendingViewModel): ViewModel
}
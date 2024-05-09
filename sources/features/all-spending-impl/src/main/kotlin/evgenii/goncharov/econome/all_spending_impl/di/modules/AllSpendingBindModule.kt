package evgenii.goncharov.econome.all_spending_impl.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.all_spending_impl.view.models.AllSpendingViewModel
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope

@Module(includes = [MultiViewModelModule::class])
internal interface AllSpendingBindModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(AllSpendingViewModel::class)]
    fun bindAllSpendingViewModel(viewModel: AllSpendingViewModel): ViewModel
}
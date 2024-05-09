package evgenii.goncharov.econome.spending_impl.di.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import evgenii.goncharov.econome.common.di.MultiViewModelModule
import evgenii.goncharov.econome.di_core.di.keys.ViewModelKey
import evgenii.goncharov.econome.di_core.di.scopes.FeatureScope
import evgenii.goncharov.econome.spending_impl.view.models.SpendingInfoViewModel

@Module(includes = [MultiViewModelModule::class])
internal interface SpendingInfoBindModule {

    @[Binds FeatureScope]
    @[IntoMap ViewModelKey(SpendingInfoViewModel::class)]
    fun bindSpendingInfoViewModel(viewModel: SpendingInfoViewModel): ViewModel
}